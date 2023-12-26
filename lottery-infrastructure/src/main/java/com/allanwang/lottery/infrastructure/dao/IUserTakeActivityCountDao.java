package com.allanwang.lottery.infrastructure.dao;


import com.allanwang.middleware.db.router.annotation.DBRouter;
import com.allanwang.lottery.infrastructure.po.UserTakeActivityCount;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description: user_take_activity_count dao
 */
@Mapper
public interface IUserTakeActivityCountDao {

    /**
     * queryUserTakeActivityCount
     * @param userTakeActivityCountReq
     * @return
     */
    @DBRouter
    UserTakeActivityCount queryUserTakeActivityCount(UserTakeActivityCount userTakeActivityCountReq);

    /**
     * insert user_take_activity_count
     * @param userTakeActivityCount
     */
//    @DBRouter
    void insert(UserTakeActivityCount userTakeActivityCount);

    /**
     * update user_take_activity_count
     * @param userTakeActivityCount
     * @return
     */
//    @DBRouter
    int updateLeftCount(UserTakeActivityCount userTakeActivityCount);

}

