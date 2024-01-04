package com.allanwang.lottery.domain.rule.service.engine;


import com.allanwang.lottery.domain.rule.model.res.EngineResult;
import com.allanwang.lottery.domain.rule.model.req.DecisionMatterReq;

/**
 * @description: rule engine filter interface
 */
public interface EngineFilter {

    /**
     * rule engine filter process
     *
     * @param matter
     * @return
     */
    EngineResult process(final DecisionMatterReq matter);

}
