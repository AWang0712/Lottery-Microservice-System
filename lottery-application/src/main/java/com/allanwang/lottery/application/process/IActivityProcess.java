package com.allanwang.lottery.application.process;

import com.allanwang.lottery.application.process.req.DrawProcessReq;
import com.allanwang.lottery.application.process.res.DrawProcessResult;

/**
 * @description: activity process interface
 */
public interface IActivityProcess {

    /**
     * execute draw process
     * @param req
     * @return
     */
    DrawProcessResult doDrawProcess(DrawProcessReq req);

}

