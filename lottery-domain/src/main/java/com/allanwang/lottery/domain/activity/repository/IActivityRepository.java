package com.allanwang.lottery.domain.activity.repository;

import com.allanwang.lottery.common.Constants;
import com.allanwang.lottery.domain.activity.model.vo.ActivityVO;
import com.allanwang.lottery.domain.activity.model.vo.AwardVO;
import com.allanwang.lottery.domain.activity.model.vo.StrategyDetailVO;
import com.allanwang.lottery.domain.activity.model.vo.StrategyVO;

import java.util.List;
/**
 * @description: Activity repository services (activity table, prize table, strategy table, strategy detail table)
 *
 **/

public interface IActivityRepository {
    /**
     * add activity
     * @param activity
     */
    void addActivity(ActivityVO activity);

    /**
     * add award
     * @param awardList
     */
    void addAward(List<AwardVO> awardList);

    /**
     * add strategy
     *
     * @param strategy
     */
    void addStrategy(StrategyVO strategy);

    /**
     * add strategy detail
     *
     * @param strategyDetailList
     */
    void addStrategyDetailList(List<StrategyDetailVO> strategyDetailList);

    /**
     * alter activity status
     *
     * @param activityId
     * @param beforeState
     * @param afterState
     * @return
     */
    boolean alterStatus(Long activityId, Enum<Constants.ActivityState> beforeState, Enum<Constants.ActivityState> afterState);

}
