package com.allanwang.lottery.domain.activity.model.aggregates;

import com.allanwang.lottery.domain.activity.model.vo.ActivityVO;
import com.allanwang.lottery.domain.activity.model.vo.AwardVO;
import com.allanwang.lottery.domain.activity.model.vo.StrategyVO;

import java.util.List;

/**
 * @description: activity config rich model
 */
public class ActivityConfigRich {
    /** activity config */
    private ActivityVO activity;

    /** strategy config (including strategy detail) */
    private StrategyVO strategy;

    /** award config */
    private List<AwardVO> awardList;

    public ActivityConfigRich() {
    }

    public ActivityConfigRich(ActivityVO activity, StrategyVO strategy, List<AwardVO> awardList) {
        this.activity = activity;
        this.strategy = strategy;
        this.awardList = awardList;
    }

    public ActivityVO getActivity() {
        return activity;
    }

    public void setActivity(ActivityVO activity) {
        this.activity = activity;
    }

    public StrategyVO getStrategy() {
        return strategy;
    }

    public void setStrategy(StrategyVO strategy) {
        this.strategy = strategy;
    }

    public List<AwardVO> getAwardList() {
        return awardList;
    }

    public void setAwardList(List<AwardVO> awardList) {
        this.awardList = awardList;
    }

}
