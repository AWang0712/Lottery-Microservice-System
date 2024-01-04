package com.allanwang.lottery.domain.rule.service.logic.impl;


import com.allanwang.lottery.domain.rule.model.req.DecisionMatterReq;
import com.allanwang.lottery.domain.rule.service.logic.BaseLogic;
import org.springframework.stereotype.Component;

/**
 * @description: user age filter
 */
@Component
public class UserAgeFilter extends BaseLogic {

    @Override
    public String matterValue(DecisionMatterReq decisionMatter) {
        return decisionMatter.getValMap().get("age").toString();
    }

}

