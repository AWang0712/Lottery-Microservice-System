package com.allanwang.lottery.infrastructure.dao;


import com.allanwang.lottery.infrastructure.po.RuleTreeNodeLine;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @description: rule_tree_node_line dao
 */
@Mapper
public interface RuleTreeNodeLineDao {

    /**
     * query rule tree node line list
     * @param req
     * @return
     */
    List<RuleTreeNodeLine> queryRuleTreeNodeLineList(RuleTreeNodeLine req);

    /**
     * query rule tree node line count
     *
     * @param treeId
     * @return
     */
    int queryTreeNodeLineCount(Long treeId);

}
