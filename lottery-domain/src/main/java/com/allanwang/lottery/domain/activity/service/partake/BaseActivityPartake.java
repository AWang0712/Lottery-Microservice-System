package com.allanwang.lottery.domain.activity.service.partake;

import com.allanwang.lottery.common.Constants;
import com.allanwang.lottery.common.Result;
import com.allanwang.lottery.domain.activity.model.req.PartakeReq;
import com.allanwang.lottery.domain.activity.model.res.PartakeResult;
import com.allanwang.lottery.domain.activity.model.vo.ActivityBillVO;
import com.allanwang.lottery.domain.activity.model.vo.UserTakeActivityVO;
import com.allanwang.lottery.domain.support.ids.IIdGenerator;

import javax.annotation.Resource;
import java.util.Map;


/**
 * @description: activity partake template abstract class
 */
public abstract class BaseActivityPartake extends ActivityPartakeSupport implements IActivityPartake {
    @Resource
    private Map<Constants.Ids, IIdGenerator> idGeneratorMap;


    @Override
    public PartakeResult doPartake(PartakeReq req) {
        // 1. check whether there are unexcuted activity orders, if there are, return the order information directly
        UserTakeActivityVO userTakeActivityVO = this.queryNoConsumedTakeActivityOrder(req.getActivityId(), req.getuId());
        if (null != userTakeActivityVO) {
            return buildPartakeResult(userTakeActivityVO.getStrategyId(), userTakeActivityVO.getTakeId());
        }

        // 2. check activity bill
        ActivityBillVO activityBillVO = super.queryActivityBill(req);

        // 3. activity info check (activity stock, status, date, personal partake times)
        Result checkResult = this.checkActivityBill(req, activityBillVO);
        if (!Constants.ResponseCode.SUCCESS.getCode().equals(checkResult.getCode())) {
            return new PartakeResult(checkResult.getCode(), checkResult.getInfo());
        }

        // 4. subtraction activity stock (now is directly operate table lottery.activity, later will be optimized to Redis)
        Result subtractionActivityResult = this.subtractionActivityStock(req);
        if (!Constants.ResponseCode.SUCCESS.getCode().equals(subtractionActivityResult.getCode())) {
            return new PartakeResult(subtractionActivityResult.getCode(), subtractionActivityResult.getInfo());
        }

        // 5. grab activity info (personal user write activity info to user table)
        Long takeId = idGeneratorMap.get(Constants.Ids.SnowFlake).nextId();
        Result grabResult = this.grabActivity(req, activityBillVO, takeId);
        if (!Constants.ResponseCode.SUCCESS.getCode().equals(grabResult.getCode())) {
            return new PartakeResult(grabResult.getCode(), grabResult.getInfo());
        }
        return buildPartakeResult(activityBillVO.getStrategyId(), takeId);
    }

    /**
     * encapsulate result
     *
     * @param strategyId
     * @param takeId
     * @return
     */
    private PartakeResult buildPartakeResult(Long strategyId, Long takeId) {

        // encapsulate result [return strategyId, used to continue to complete the lottery step]
        PartakeResult partakeResult = new PartakeResult(Constants.ResponseCode.SUCCESS.getCode(), Constants.ResponseCode.SUCCESS.getInfo());
        partakeResult.setStrategyId(strategyId);
        partakeResult.setTakeId(takeId);

        return partakeResult;
    }

    /**
     * query not consumed take activity order
     *
     * @param activityId
     * @param uId
     * @return
     */
    protected abstract UserTakeActivityVO queryNoConsumedTakeActivityOrder(Long activityId, String uId);


    /**
     * check activity bill
     *
     * @param partake activity partake request
     * @param bill
     * @return check result
     */
    protected abstract Result checkActivityBill(PartakeReq partake, ActivityBillVO bill);

    /**
     * subtraction activity stock
     *
     * @param req activity partake request
     * @return subtraction result
     */
    protected abstract Result subtractionActivityStock(PartakeReq req);

    /**
     * partake activity
     *
     * @param partake activity partake request
     * @param bill
     * @param takeId
     * @return partake result
     */
    protected abstract Result grabActivity(PartakeReq partake, ActivityBillVO bill, Long takeId);

}

