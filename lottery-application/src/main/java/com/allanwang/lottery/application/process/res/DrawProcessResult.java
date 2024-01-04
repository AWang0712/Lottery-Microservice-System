package com.allanwang.lottery.application.process.res;

import com.allanwang.lottery.common.Result;
import com.allanwang.lottery.domain.strategy.model.vo.DrawAwardVO;

/**
 * @description: award process result
 */
public class DrawProcessResult extends Result {

    private DrawAwardVO drawAwardInfo;

    public DrawProcessResult(String code, String info) {
        super(code, info);
    }

    public DrawProcessResult(String code, String info, DrawAwardVO drawAwardInfo) {
        super(code, info);
        this.drawAwardInfo = drawAwardInfo;
    }

    public DrawAwardVO getDrawAwardInfo() {
        return drawAwardInfo;
    }

    public void setDrawAwardInfo(DrawAwardVO drawAwardInfo) {
        this.drawAwardInfo = drawAwardInfo;
    }
}
