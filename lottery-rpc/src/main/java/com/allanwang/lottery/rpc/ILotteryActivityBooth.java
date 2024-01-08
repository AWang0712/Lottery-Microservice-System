package com.allanwang.lottery.rpc;

import com.allanwang.lottery.rpc.req.DrawReq;
import com.allanwang.lottery.rpc.req.QuantificationDrawReq;
import com.allanwang.lottery.rpc.res.DrawRes;

/**
 * @description: lottery activity booth interface
 */
public interface ILotteryActivityBooth {

    /**
     * activity draw
     * @param drawReq
     * @return
     */
    DrawRes doDraw(DrawReq drawReq);

    /**
     * quantification crowd draw
     * @param quantificationDrawReq
     * @return
     */
    DrawRes doQuantificationDraw(QuantificationDrawReq quantificationDrawReq);

}

