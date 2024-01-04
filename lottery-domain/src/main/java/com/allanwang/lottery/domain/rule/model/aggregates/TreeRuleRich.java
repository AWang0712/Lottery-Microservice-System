package com.allanwang.lottery.domain.rule.model.aggregates;

import com.allanwang.lottery.domain.rule.model.vo.TreeNodeVO;
import com.allanwang.lottery.domain.rule.model.vo.TreeRootVO;

import java.util.Map;

/**
 * @description: rule tree rich model
 */
public class TreeRuleRich {

    /** tree root */
    private TreeRootVO treeRoot;
    /** <nodeId, treeNode> */
    private Map<Long, TreeNodeVO> treeNodeMap;

    public TreeRootVO getTreeRoot() {
        return treeRoot;
    }

    public void setTreeRoot(TreeRootVO treeRoot) {
        this.treeRoot = treeRoot;
    }

    public Map<Long, TreeNodeVO> getTreeNodeMap() {
        return treeNodeMap;
    }

    public void setTreeNodeMap(Map<Long, TreeNodeVO> treeNodeMap) {
        this.treeNodeMap = treeNodeMap;
    }
}

