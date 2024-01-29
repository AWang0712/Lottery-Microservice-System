package com.allanwang.lottery.domain.activity.service.deploy;

import com.allanwang.lottery.domain.activity.model.req.ActivityConfigReq;
import com.allanwang.lottery.domain.activity.model.vo.ActivityVO;

import java.util.List;

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

    /**
     * scan activity list to be processed
     * @param id ID
     * @return activity list to be processed
     */
    List<ActivityVO> scanToDoActivityList(Long id);


}
