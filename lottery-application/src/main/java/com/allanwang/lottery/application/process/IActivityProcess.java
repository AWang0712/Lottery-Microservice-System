package com.allanwang.lottery.application.process;

import com.allanwang.lottery.application.process.req.DrawProcessReq;
import com.allanwang.lottery.application.process.res.DrawProcessResult;
import com.allanwang.lottery.application.process.res.RuleQuantificationCrowdResult;
import com.allanwang.lottery.domain.rule.model.req.DecisionMatterReq;


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

    /**
     * rule quantification crowd, return the activity id that user can join
     * @param req
     * @return
     */
    RuleQuantificationCrowdResult doRuleQuantificationCrowd(DecisionMatterReq req);


}

