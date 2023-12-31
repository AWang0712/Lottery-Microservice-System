package com.allanwang.lottery.domain.strategy.service.draw;

import com.allanwang.lottery.common.Constants;
import com.allanwang.lottery.domain.strategy.model.aggregates.StrategyRich;
import com.allanwang.lottery.domain.strategy.model.req.DrawReq;
import com.allanwang.lottery.domain.strategy.model.res.DrawResult;
import com.allanwang.lottery.domain.strategy.model.vo.*;
import com.allanwang.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: define lottery process, template method pattern
 */
public abstract class AbstractDrawBase extends DrawStrategySupport implements IDrawExec {

    private Logger logger = LoggerFactory.getLogger(AbstractDrawBase.class);

    @Override
    public DrawResult doDrawExec(DrawReq req) {
        // 1. get the strategy
        StrategyRich strategyRich = super.queryStrategyRich(req.getStrategyId());
        StrategyBriefVO strategy = strategyRich.getStrategy();

        // 2. check and init the rate data
        this.checkAndInitRateData(req.getStrategyId(), strategy.getStrategyMode(), strategyRich.getStrategyDetailList());

        // 3. get the excluded awardIds
        List<String> excludeAwardIds = this.queryExcludeAwardIds(req.getStrategyId());

        // 4. execute the draw algorithm
        String awardId = this.drawAlgorithm(req.getStrategyId(), drawAlgorithmGroup.get(strategy.getStrategyMode()), excludeAwardIds);

        // 5. encapsulate the draw result
        return buildDrawResult(req.getuId(), req.getStrategyId(), awardId, strategy);
    }

    /**
     * 3.
     * Get the list of exclusions from the sweepstakes, including: prize inventory is empty, risk control strategy, temporary adjustments, etc.
     * This type of data contains business logic, so it needs to be decided by the specific implementer
     *
     * @param strategyId
     * @return collection of excluded awardIds
     */
    protected abstract List<String> queryExcludeAwardIds(Long strategyId);

    /**
     * 4.
     * Execute the draw algorithm
     *
     * @param strategyId
     * @param drawAlgorithm
     * @param excludeAwardIds
     * @return awardId
     */
    protected abstract String drawAlgorithm(Long strategyId, IDrawAlgorithm drawAlgorithm, List<String> excludeAwardIds);

    /**
     * 2.
     * check and init the rate data
     *
     * @param strategyId
     * @param strategyMode
     * @param strategyDetailList
     */
    private void checkAndInitRateData(Long strategyId, Integer strategyMode, List<StrategyDetailBriefVO> strategyDetailList) {

        /*this if statement will cause NullPointerException if strategyMode is Entirety
        because rateTuple will not be initialized*/

        /* not single mode, no need to check and init
        if (!Constants.StrategyMode.SINGLE.getCode().equals(strategyMode)) {
            return;
        }*/

        IDrawAlgorithm drawAlgorithm = drawAlgorithmGroup.get(strategyMode);

        // check if the rate data has been initialized
        if (drawAlgorithm.isExist(strategyId)) {
            return;
        }

        // parse and init the rate data to hashmap
        List<AwardRateVO> awardRateInfoList = new ArrayList<>(strategyDetailList.size());
        for (StrategyDetailBriefVO strategyDetail : strategyDetailList) {
            awardRateInfoList.add(new AwardRateVO(strategyDetail.getAwardId(), strategyDetail.getAwardRate()));
        }

        drawAlgorithm.initRateTuple(strategyId, strategyMode, awardRateInfoList);

    }

    /**
     * 5.
     * encapsulate the draw result
     *
     * @param uId
     * @param strategyId
     * @param awardId    Prize ID, null Case: In case of concurrent draws, inventory threshold 1 -> 0, there will be a user who wins with null result.
     * @return DrawResult
     */
    private DrawResult buildDrawResult(String uId, Long strategyId, String awardId, StrategyBriefVO strategy) {
        if (null == awardId) {
            logger.info("strategy lottery completed[not won], user：{} strategy ID：{}", uId, strategyId);
            return new DrawResult(uId, strategyId, Constants.DrawState.FAIL.getCode());
        }

        AwardBriefVO award = super.queryAwardInfoByAwardId(awardId);
        DrawAwardVO drawAwardInfo = new DrawAwardVO(uId, award.getAwardId(), award.getAwardType(), award.getAwardName(), award.getAwardContent());
        drawAwardInfo.setStrategyMode(strategy.getStrategyMode());
        drawAwardInfo.setGrantType(strategy.getGrantType());
        drawAwardInfo.setGrantDate(strategy.getGrantDate());
        logger.info("strategy lottery completed[won], user：{} strategy ID：{} award ID：{} award name：{}", uId, strategyId, awardId, award.getAwardName());

        return new DrawResult(uId, strategyId, Constants.DrawState.SUCCESS.getCode(), drawAwardInfo);
    }

}

