package com.allanwang.lottery.rpc.res;

import com.allanwang.lottery.common.Result;
import com.allanwang.lottery.rpc.dto.AwardDTO;

import java.io.Serializable;

/**
 * @description: lottery result for draw
 */
public class DrawRes extends Result implements Serializable {

    private AwardDTO awardDTO;

    public DrawRes(String code, String info) {
        super(code, info);
    }

    public AwardDTO getAwardDTO() {
        return awardDTO;
    }

    public void setAwardDTO(AwardDTO awardDTO) {
        this.awardDTO = awardDTO;
    }

}

