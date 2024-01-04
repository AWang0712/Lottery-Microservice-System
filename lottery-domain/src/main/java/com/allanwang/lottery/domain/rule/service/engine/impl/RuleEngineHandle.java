package com.allanwang.lottery.domain.rule.service.engine.impl;

import com.allanwang.lottery.domain.rule.model.aggregates.TreeRuleRich;
import com.allanwang.lottery.domain.rule.model.res.EngineResult;
import com.allanwang.lottery.domain.rule.model.req.DecisionMatterReq;
import com.allanwang.lottery.domain.rule.model.vo.TreeNodeVO;
import com.allanwang.lottery.domain.rule.repository.IRuleRepository;
import com.allanwang.lottery.domain.rule.service.engine.EngineBase;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description: rule engine handler
 */
@Service("ruleEngineHandle")
public class RuleEngineHandle extends EngineBase {

    @Resource
    private IRuleRepository ruleRepository;

    @Override
    public EngineResult process(DecisionMatterReq matter) {
        // decision tree
        TreeRuleRich treeRuleRich = ruleRepository.queryTreeRuleRich(matter.getTreeId());
        if (null == treeRuleRich) {
            throw new RuntimeException("Tree Rule is null!");
        }

        // decision tree node
        TreeNodeVO treeNodeInfo = engineDecisionMaker(treeRuleRich, matter);

        // decision result
        return new EngineResult(matter.getUserId(), treeNodeInfo.getTreeId(), treeNodeInfo.getTreeNodeId(), treeNodeInfo.getNodeValue());
    }

}

