package com.allanwang.lottery.domain.activity.service.deploy;

import com.allanwang.lottery.domain.activity.model.req.ActivityConfigReq;
public interface IActivityDeploy {
    /**
     * create activity
     *
     * @param req
     */
    void createActivity(ActivityConfigReq req);

    /**
     * update activity
     *
     * @param req
     */
    void updateActivity(ActivityConfigReq req);

}
