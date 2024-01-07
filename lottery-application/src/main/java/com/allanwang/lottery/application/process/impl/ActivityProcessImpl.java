package com.allanwang.lottery.application.process.impl;

import com.allanwang.lottery.application.process.IActivityProcess;
import com.allanwang.lottery.application.process.req.DrawProcessReq;
import com.allanwang.lottery.application.process.res.DrawProcessResult;
import com.allanwang.lottery.application.process.res.RuleQuantificationCrowdResult;
import com.allanwang.lottery.common.Constants;
import com.allanwang.lottery.common.Result;
import com.allanwang.lottery.domain.activity.model.req.PartakeReq;
import com.allanwang.lottery.domain.activity.model.res.PartakeResult;
import com.allanwang.lottery.domain.activity.model.vo.DrawOrderVO;
import com.allanwang.lottery.domain.activity.service.partake.IActivityPartake;
import com.allanwang.lottery.domain.rule.model.req.DecisionMatterReq;
import com.allanwang.lottery.domain.rule.model.res.EngineResult;
import com.allanwang.lottery.domain.rule.service.engine.EngineFilter;
import com.allanwang.lottery.domain.strategy.model.req.DrawReq;
import com.allanwang.lottery.domain.strategy.model.res.DrawResult;
import com.allanwang.lottery.domain.strategy.model.vo.DrawAwardVO;
import com.allanwang.lottery.domain.strategy.service.draw.IDrawExec;
import com.allanwang.lottery.domain.support.ids.IIdGenerator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description: activity process impl
 */
@Service
public class ActivityProcessImpl implements IActivityProcess {

    @Resource
    private IActivityPartake activityPartake;

    @Resource
    private IDrawExec drawExec;

    @Resource(name = "ruleEngineHandle")
    private EngineFilter engineFilter;

    @Resource
    private Map<Constants.Ids, IIdGenerator> idGeneratorMap;

    @Override
    public DrawProcessResult doDrawProcess(DrawProcessReq req) {
        // 1. take activity
        PartakeResult partakeResult = activityPartake.doPartake(new PartakeReq(req.getuId(), req.getActivityId()));
        if (!Constants.ResponseCode.SUCCESS.getCode().equals(partakeResult.getCode())) {
            return new DrawProcessResult(partakeResult.getCode(), partakeResult.getInfo());
        }
        Long strategyId = partakeResult.getStrategyId();
        Long takeId = partakeResult.getTakeId();

        // 2. execute draw
        DrawResult drawResult = drawExec.doDrawExec(new DrawReq(req.getuId(), strategyId));
        if (Constants.DrawState.FAIL.getCode().equals(drawResult.getDrawState())) {
            return new DrawProcessResult(Constants.ResponseCode.LOSING_DRAW.getCode(), Constants.ResponseCode.LOSING_DRAW.getInfo());
        }
        DrawAwardVO drawAwardVO = drawResult.getDrawAwardInfo();

        // 3. record draw order
        activityPartake.recordDrawOrder(buildDrawOrderVO(req, strategyId, takeId, drawAwardVO));

        // 4. send MQ, set out grant task

        // 5. return result
        return new DrawProcessResult(Constants.ResponseCode.SUCCESS.getCode(), Constants.ResponseCode.SUCCESS.getInfo(), drawAwardVO);
    }

    @Override
    public RuleQuantificationCrowdResult doRuleQuantificationCrowd(DecisionMatterReq req) {
        // 1. rule engine
        EngineResult engineResult = engineFilter.process(req);

        if (!engineResult.isSuccess()) {
            return new RuleQuantificationCrowdResult(Constants.ResponseCode.RULE_ERR.getCode(),Constants.ResponseCode.RULE_ERR.getInfo());
        }

        // 2. encapsulation result
        RuleQuantificationCrowdResult ruleQuantificationCrowdResult = new RuleQuantificationCrowdResult(Constants.ResponseCode.SUCCESS.getCode(), Constants.ResponseCode.SUCCESS.getInfo());
        ruleQuantificationCrowdResult.setActivityId(Long.valueOf(engineResult.getNodeValue()));

        return ruleQuantificationCrowdResult;

    }

    private DrawOrderVO buildDrawOrderVO(DrawProcessReq req, Long strategyId, Long takeId, DrawAwardVO drawAwardVO) {
        long orderId = idGeneratorMap.get(Constants.Ids.SnowFlake).nextId();
        DrawOrderVO drawOrderVO = new DrawOrderVO();
        drawOrderVO.setuId(req.getuId());
        drawOrderVO.setTakeId(takeId);
        drawOrderVO.setActivityId(req.getActivityId());
        drawOrderVO.setOrderId(orderId);
        drawOrderVO.setStrategyId(strategyId);
        drawOrderVO.setStrategyMode(drawAwardVO.getStrategyMode());
        drawOrderVO.setGrantType(drawAwardVO.getGrantType());
        drawOrderVO.setGrantDate(drawAwardVO.getGrantDate());
        drawOrderVO.setGrantState(Constants.GrantState.INIT.getCode());
        drawOrderVO.setAwardId(drawAwardVO.getAwardId());
        drawOrderVO.setAwardType(drawAwardVO.getAwardType());
        drawOrderVO.setAwardName(drawAwardVO.getAwardName());
        drawOrderVO.setAwardContent(drawAwardVO.getAwardContent());
        return drawOrderVO;
    }

}

