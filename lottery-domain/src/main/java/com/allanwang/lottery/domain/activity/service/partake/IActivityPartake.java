package com.allanwang.lottery.domain.activity.service.partake;

import com.allanwang.lottery.common.Result;
import com.allanwang.lottery.domain.activity.model.req.PartakeReq;
import com.allanwang.lottery.domain.activity.model.res.PartakeResult;
import com.allanwang.lottery.domain.activity.model.vo.DrawOrderVO;


public interface IActivityPartake {
    /**
     * partake activity
     * @param req
     * @return
     */
    PartakeResult doPartake(PartakeReq req);

    /**
     * save draw order
     * @param drawOrder
     * @return
     */
    Result recordDrawOrder(DrawOrderVO drawOrder);

}
