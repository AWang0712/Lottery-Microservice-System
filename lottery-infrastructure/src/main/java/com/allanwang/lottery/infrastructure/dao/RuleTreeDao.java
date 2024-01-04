package com.allanwang.lottery.infrastructure.dao;


import com.allanwang.lottery.infrastructure.po.RuleTree;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description: rule tree config dao
 */
@Mapper
public interface RuleTreeDao {

    /**
     * rule tree query by id
     * @param id ID
     * @return
     */
    RuleTree queryRuleTreeByTreeId(Long id);

    /**
     * query rule tree summary info
     * @param treeId
     * @return
     */
    RuleTree queryTreeSummaryInfo(Long treeId);

}

