package com.allanwang.lottery.infrastructure.dao;


import com.allanwang.lottery.infrastructure.po.RuleTreeNode;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @description: rule tree node dao
 */
@Mapper
public interface RuleTreeNodeDao {

    /**
     * query rule tree node
     * @param treeId
     * @return          rule tree node list
     */
    List<RuleTreeNode> queryRuleTreeNodeList(Long treeId);

    /**
     * query rule tree node count
     * @param treeId
     * @return
     */
    int queryTreeNodeCount(Long treeId);

    /**
     * query rule tree node
     *
     * @param treeId
     * @return
     */
    List<RuleTreeNode> queryTreeRulePoint(Long treeId);

}
