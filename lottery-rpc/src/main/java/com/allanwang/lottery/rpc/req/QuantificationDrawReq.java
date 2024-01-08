package com.allanwang.lottery.rpc.req;

import java.util.Map;

/**
 * @description: quantification crowd draw req
 */
public class QuantificationDrawReq {

    /** uid */
    private String uId;
    /** tree id */
    private Long treeId;
    /** matter value map */
    private Map<String, Object> valMap;

    public Long getTreeId() {
        return treeId;
    }

    public void setTreeId(Long treeId) {
        this.treeId = treeId;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public Map<String, Object> getValMap() {
        return valMap;
    }

    public void setValMap(Map<String, Object> valMap) {
        this.valMap = valMap;
    }

}
