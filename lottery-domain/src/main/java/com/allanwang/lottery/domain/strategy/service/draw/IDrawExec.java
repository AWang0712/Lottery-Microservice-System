package com.allanwang.lottery.domain.strategy.service.draw;

import com.allanwang.lottery.domain.strategy.model.req.DrawReq;
import com.allanwang.lottery.domain.strategy.model.res.DrawResult;
public interface IDrawExec {
    DrawResult doDrawExec(DrawReq req);
}
