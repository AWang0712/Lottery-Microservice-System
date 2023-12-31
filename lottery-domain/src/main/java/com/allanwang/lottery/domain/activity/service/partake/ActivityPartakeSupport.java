package com.allanwang.lottery.domain.activity.service.partake;


import com.allanwang.lottery.domain.activity.model.req.PartakeReq;
import com.allanwang.lottery.domain.activity.model.vo.ActivityBillVO;
import com.allanwang.lottery.domain.activity.repository.IActivityRepository;

import javax.annotation.Resource;

/**
 * @description: activity partake support
 */
public class ActivityPartakeSupport {

    @Resource
    protected IActivityRepository activityRepository;

    protected ActivityBillVO queryActivityBill(PartakeReq req){
        return activityRepository.queryActivityBill(req);
    }

}
