package com.allanwang.lottery.domain.rule.service.logic;



import com.allanwang.lottery.domain.rule.model.req.DecisionMatterReq;
import com.allanwang.lottery.domain.rule.model.vo.TreeNodeLineVO;

import java.util.List;

/**
 * @description: rule filter interface
 */
public interface LogicFilter {

    /**
     * logic filter
     * @param matterValue
     * @param treeNodeLineInfoList
     * @return                     next node id
     */
    Long filter(String matterValue, List<TreeNodeLineVO> treeNodeLineInfoList);

    /**
     * get matter value
     *
     * @param decisionMatter
     * @return               matter value
     */
    String matterValue(DecisionMatterReq decisionMatter);

}
