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
    void insert(UserTakeActivity userTakeActivity);

    /**
     * lock activity take record
     *
     * @param userTakeActivity
     * @return
     */
    int lockTackActivity(UserTakeActivity userTakeActivity);

    /**
     * check whether there is an unexecuted lottery receiving activity order [user_take_activity exists state = 0, received but lottery process failed, can directly return the receiving result to continue the lottery]
     * Query the earliest record of this activity ID and user that has not been consumed [this part generally has business process restrictions, such as whether to process the first or latest receiving order, depending on the actual business scenario]
     * @param userTakeActivity
     * @return
     */
    @DBRouter
    UserTakeActivity queryNoConsumedTakeActivityOrder(UserTakeActivity userTakeActivity);


}
