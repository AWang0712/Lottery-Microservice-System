package com.allanwang.lottery.rpc;

import com.allanwang.lottery.rpc.req.ActivityReq;
import com.allanwang.lottery.rpc.res.ActivityRes;
public interface IActivityBooth {
    ActivityRes queryActivityById(ActivityReq req);
}
