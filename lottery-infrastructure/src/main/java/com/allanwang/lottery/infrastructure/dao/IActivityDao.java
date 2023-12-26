package com.allanwang.lottery.infrastructure.dao;

import com.allanwang.lottery.domain.activity.model.req.PartakeReq;
import com.allanwang.lottery.domain.activity.model.vo.AlterStateVO;
import com.allanwang.lottery.infrastructure.po.Activity;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface IActivityDao {
    /**
     * insert data
     *
     * @param req
     */
    void insert(Activity req);

    /**
     * query by id
     *
     * @param activityId
     * @return
     */
    Activity queryActivityById(Long activityId);

    /**
     * alter state
     *
     * @param alterStateVO  [activityId、beforeState、afterState]
     * @return
     */
    int alterState(AlterStateVO alterStateVO);

    /**
     * subtract activity stock
     * @param activityId
     * @return
     */
    int subtractionActivityStock(Long activityId);


}
