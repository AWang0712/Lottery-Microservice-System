package com.allanwang.lottery.infrastructure.po;

/**
 * @description: rule_tree_node_line po
 */
public class RuleTreeNodeLine {

    /** pk */
    private Long id;
    /** rule_tree id */
    private Long treeId;
    /** node from */
    private Long nodeIdFrom;
    /** node to */
    private Long nodeIdTo;
    /** type: 1:=;2:>;3:<;4:>=;5<=;6:enum */
    private Integer ruleLimitType;
    /** rule limit value */
    private String ruleLimitValue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTreeId() {
        return treeId;
    }

    public void setTreeId(Long treeId) {
        this.treeId = treeId;
    }

    public Long getNodeIdFrom() {
        return nodeIdFrom;
    }

    public void setNodeIdFrom(Long nodeIdFrom) {
        this.nodeIdFrom = nodeIdFrom;
    }

    public Long getNodeIdTo() {
        return nodeIdTo;
    }

    public void setNodeIdTo(Long nodeIdTo) {
        this.nodeIdTo = nodeIdTo;
    }

    public Integer getRuleLimitType() {
        return ruleLimitType;
    }

    public void setRuleLimitType(Integer ruleLimitType) {
        this.ruleLimitType = ruleLimitType;
    }

    public String getRuleLimitValue() {
        return ruleLimitValue;
    }

    public void setRuleLimitValue(String ruleLimitValue) {
        this.ruleLimitValue = ruleLimitValue;
    }
}
