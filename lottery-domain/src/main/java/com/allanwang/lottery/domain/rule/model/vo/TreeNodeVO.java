package com.allanwang.lottery.domain.rule.model.vo;

import java.util.List;

/**
 * @description: rule tree node vo
 */
public class TreeNodeVO {

    /** rule tree ID */
    private Long treeId;
    /** rule tree node ID */
    private Long treeNodeId;
    /** node type */
    private Integer nodeType;
    /** node value */
    private String nodeValue;
    /** rule Key */
    private String ruleKey;
    /** rule desc */
    private String ruleDesc;
    /** tree node line info list */
    private List<TreeNodeLineVO> treeNodeLineInfoList;

    public Long getTreeId() {
        return treeId;
    }

    public void setTreeId(Long treeId) {
        this.treeId = treeId;
    }

    public Long getTreeNodeId() {
        return treeNodeId;
    }

    public void setTreeNodeId(Long treeNodeId) {
        this.treeNodeId = treeNodeId;
    }

    public Integer getNodeType() {
        return nodeType;
    }

    public void setNodeType(Integer nodeType) {
        this.nodeType = nodeType;
    }

    public String getNodeValue() {
        return nodeValue;
    }

    public void setNodeValue(String nodeValue) {
        this.nodeValue = nodeValue;
    }

    public String getRuleKey() {
        return ruleKey;
    }

    public void setRuleKey(String ruleKey) {
        this.ruleKey = ruleKey;
    }

    public String getRuleDesc() {
        return ruleDesc;
    }

    public void setRuleDesc(String ruleDesc) {
        this.ruleDesc = ruleDesc;
    }

    public List<TreeNodeLineVO> getTreeNodeLineInfoList() {
        return treeNodeLineInfoList;
    }

    public void setTreeNodeLineInfoList(List<TreeNodeLineVO> treeNodeLineInfoList) {
        this.treeNodeLineInfoList = treeNodeLineInfoList;
    }

    @Override
    public String toString() {
        return "TreeNodeVO{" +
                "treeId=" + treeId +
                ", treeNodeId=" + treeNodeId +
                ", nodeType=" + nodeType +
                ", nodeValue='" + nodeValue + '\'' +
                ", ruleKey='" + ruleKey + '\'' +
                ", ruleDesc='" + ruleDesc + '\'' +
                ", treeNodeLineInfoList=" + treeNodeLineInfoList +
                '}';
    }
}

