package com.allanwang.lottery.infrastructure.dao;

import com.allanwang.middleware.db.router.annotation.DBRouter;
import com.allanwang.lottery.infrastructure.po.UserTakeActivity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description: user_take_activity dao
 */
@Mapper
public interface IUserTakeActivityDao {

    /**
     * insert
     *
     * @param userTakeActivity
     */
    @DBRouter(key = "uId")
    void insert(UserTakeActivity userTakeActivity);

}
