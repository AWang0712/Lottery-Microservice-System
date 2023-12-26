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

    public PartakeResult(String code, String info) {
        super(code, info);
    }

    public Long getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(Long strategyId) {
        this.strategyId = strategyId;
    }
}
