package com.allanwang.lottery.infrastructure.dao;

import com.allanwang.lottery.infrastructure.po.Activity;
import org.apache.ibatis.annotations.Mapper;
public interface IActivityDao {
    void insert(Activity req);

    Activity queryActivityById(Long activityId);
}
