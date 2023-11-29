package com.allanwang.lottery.infrastructure.dao;

import com.allanwang.lottery.infrastructure.po.Award;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @description: award dao
 */
@Mapper
public interface IAwardDao {

    /**
     * query award info
     *
     * @param awardId
     * @return
     */
    Award queryAwardInfo(String awardId);

    /**
     * insert award info
     *
     * @param list
     */
    void insertList(List<Award> list);

}

