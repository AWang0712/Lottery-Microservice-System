package com.allanwang.lottery.domain.strategy.service.draw;

import com.allanwang.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
public class DrawConfig {
    @Resource
    private IDrawAlgorithm defaultRateRandomDrawAlgorithm;

    @Resource
    private IDrawAlgorithm singleRateRandomDrawAlgorithm;

    protected static Map<Integer, IDrawAlgorithm> drawAlgorithmMap = new ConcurrentHashMap<>();

    @PostConstruct
    public void init() {
        drawAlgorithmMap.put(1, defaultRateRandomDrawAlgorithm);
        drawAlgorithmMap.put(2, singleRateRandomDrawAlgorithm);
    }
}