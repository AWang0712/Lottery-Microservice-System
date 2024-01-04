package com.allanwang.lottery.domain.rule.repository;


import com.allanwang.lottery.domain.rule.model.aggregates.TreeRuleRich;

/**
 * @description: rule info repository interface
 */
public interface IRuleRepository {

    /**
     * query tree rule rich info
     *
     * @param treeId
     * @return
     */
    TreeRuleRich queryTreeRuleRich(Long treeId);

}

