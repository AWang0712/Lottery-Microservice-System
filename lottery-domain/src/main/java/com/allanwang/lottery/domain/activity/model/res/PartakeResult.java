package com.allanwang.lottery.domain.activity.model.res;


import com.allanwang.lottery.common.Result;

/**
 * @description: partake result
 */
public class PartakeResult extends Result {

    /**
     * strategy id
     */
    private Long strategyId;

    /**
     * activity take id
     */
    private Long takeId;


    public PartakeResult(String code, String info) {
        super(code, info);
    }

    public Long getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(Long strategyId) {
        this.strategyId = strategyId;
    }

    public Long getTakeId() {
        return takeId;
    }

    public void setTakeId(Long takeId) {
        this.takeId = takeId;
    }

}
