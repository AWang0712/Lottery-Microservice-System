package com.allanwang.lottery.domain.activity.service.deploy.impl;

import com.allanwang.lottery.domain.activity.model.aggregates.ActivityConfigRich;
import com.allanwang.lottery.domain.activity.model.req.ActivityConfigReq;
import com.allanwang.lottery.domain.activity.model.vo.ActivityVO;
import com.allanwang.lottery.domain.activity.model.vo.AwardVO;
import com.allanwang.lottery.domain.activity.model.vo.StrategyDetailVO;
import com.allanwang.lottery.domain.activity.model.vo.StrategyVO;
import com.allanwang.lottery.domain.activity.repository.IActivityRepository;
import com.allanwang.lottery.domain.activity.service.deploy.IActivityDeploy;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ActivityDeployImpl implements IActivityDeploy {

    private Logger logger = LoggerFactory.getLogger(ActivityDeployImpl.class);

    @Resource
    private IActivityRepository activityRepository;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void createActivity(ActivityConfigReq req) {
        logger.info("Creating activity config starts, activityId：{}", req.getActivityId());
        ActivityConfigRich activityConfigRich = req.getActivityConfigRich();
        try {
            // add activity
            ActivityVO activity = activityConfigRich.getActivity();
            activityRepository.addActivity(activity);

            // add award
            List<AwardVO> awardList = activityConfigRich.getAwardList();
            activityRepository.addAward(awardList);

            // add strategy
            StrategyVO strategy = activityConfigRich.getStrategy();
            activityRepository.addStrategy(strategy);

            // add strategy detail
            List<StrategyDetailVO> strategyDetailList = activityConfigRich.getStrategy().getStrategyDetailList();
            activityRepository.addStrategyDetailList(strategyDetailList);

            logger.info("Creating activity config completed, activityId：{}", req.getActivityId());
        } catch (DuplicateKeyException e) {
            logger.error("Failed to create active configuration, unique index conflict, activityId：{} reqJson：{}", req.getActivityId(), JSON.toJSONString(req), e);
            throw e;
        }
    }

    @Override
    public void updateActivity(ActivityConfigReq req) {
        // TODO: Subsequent additions of non-core functions
    }

    @Override
    public List<ActivityVO> scanToDoActivityList(Long id) {
        return activityRepository.scanToDoActivityList(id);
    }

}

