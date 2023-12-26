package com.allanwang.lottery.domain.activity.service.partake;

import com.allanwang.lottery.domain.activity.model.req.PartakeReq;
import com.allanwang.lottery.domain.activity.model.res.PartakeResult;


public interface IActivityPartake {
    /**
     * partake activity
     * @param req
     * @return
     */
    PartakeResult doPartake(PartakeReq req);

}
