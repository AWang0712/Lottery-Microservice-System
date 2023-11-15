package com.allanwang.lottery.interfaces;

import com.allanwang.lottery.common.Constants;
import com.allanwang.lottery.common.Result;
import com.allanwang.lottery.infrastructure.dao.IActivityDao;
import com.allanwang.lottery.infrastructure.po.Activity;
import com.allanwang.lottery.rpc.IActivityBooth;
import com.allanwang.lottery.rpc.dto.ActivityDto;
import com.allanwang.lottery.rpc.req.ActivityReq;
import com.allanwang.lottery.rpc.res.ActivityRes;
import org.apache.dubbo.config.annotation.Service;


import javax.annotation.Resource;

@org.apache.dubbo.config.annotation.Service
public class ActivityBooth implements IActivityBooth{
    @Resource
    private IActivityDao activityDao;

    @Override
    public ActivityRes queryActivityById(ActivityReq req) {

        Activity activity = activityDao.queryActivityById(req.getActivityId());

        ActivityDto activityDto = new ActivityDto();
        activityDto.setActivityId(activity.getActivityId());
        activityDto.setActivityName(activity.getActivityName());
        activityDto.setActivityDesc(activity.getActivityDesc());
        activityDto.setBeginDateTime(activity.getBeginDateTime());
        activityDto.setEndDateTime(activity.getEndDateTime());
        activityDto.setStockCount(activity.getStockCount());
        activityDto.setTakeCount(activity.getTakeCount());

        return new ActivityRes(new Result(Constants.ResponseCode.SUCCESS.getCode(), Constants.ResponseCode.SUCCESS.getInfo()), activityDto);
    }
}
