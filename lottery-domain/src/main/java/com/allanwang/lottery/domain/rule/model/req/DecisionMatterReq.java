package com.allanwang.lottery.domain.rule.model.req;

import java.util.Map;

/**
 * @description: decision matter req
 */
public class DecisionMatterReq {

    /** rule tree id */
    private Long treeId;
    /** user id */
    private String userId;
    /** decision matter value map */
    private Map<String, Object> valMap;

    public DecisionMatterReq() {
    }

    public DecisionMatterReq(String userId, Long treeId, Map<String, Object> valMap) {
        this.userId = userId;
        this.treeId = treeId;
        this.valMap = valMap;
    }

    public Long getTreeId() {
        return treeId;
    }

    public void setTreeId(Long treeId) {
        this.treeId = treeId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Map<String, Object> getValMap() {
        return valMap;
    }


    public void setValMap(Map<String, Object> valMap) {
        this.valMap = valMap;
    }

}
