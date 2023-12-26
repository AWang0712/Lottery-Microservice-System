package com.allanwang.lottery.domain.activity.service.partake;

import com.allanwang.lottery.common.Constants;
import com.allanwang.lottery.common.Result;
import com.allanwang.lottery.domain.activity.model.req.PartakeReq;
import com.allanwang.lottery.domain.activity.model.res.PartakeResult;
import com.allanwang.lottery.domain.activity.model.vo.ActivityBillVO;

/**
 * @description: activity partake template abstract class
 */
public abstract class BaseActivityPartake extends ActivityPartakeSupport implements IActivityPartake {

    @Override
    public PartakeResult doPartake(PartakeReq req) {
        // query activity bill
        ActivityBillVO activityBillVO = super.queryActivityBill(req);

        // activity info check (activity stock, status, date, personal partake times)
        Result checkResult = this.checkActivityBill(req, activityBillVO);
        if (!Constants.ResponseCode.SUCCESS.getCode().equals(checkResult.getCode())) {
            return new PartakeResult(checkResult.getCode(), checkResult.getInfo());
        }

        // subtraction activity stock (now is directly operate table lottery.activity, later will be optimized to Redis)
        Result subtractionActivityResult = this.subtractionActivityStock(req);
        if (!Constants.ResponseCode.SUCCESS.getCode().equals(subtractionActivityResult.getCode())) {
            return new PartakeResult(subtractionActivityResult.getCode(), subtractionActivityResult.getInfo());
        }

        // grab activity info (personal user write activity info to user table)
        Result grabResult = this.grabActivity(req, activityBillVO);
        if (!Constants.ResponseCode.SUCCESS.getCode().equals(grabResult.getCode())) {
            return new PartakeResult(grabResult.getCode(), grabResult.getInfo());
        }

        // encapsulate result [return strategyId, used to continue to complete the lottery step]
        PartakeResult partakeResult = new PartakeResult(Constants.ResponseCode.SUCCESS.getCode(), Constants.ResponseCode.SUCCESS.getInfo());
        partakeResult.setStrategyId(activityBillVO.getStrategyId());
        return partakeResult;
    }

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
     * @return partake result
     */
    protected abstract Result grabActivity(PartakeReq partake, ActivityBillVO bill);

}

