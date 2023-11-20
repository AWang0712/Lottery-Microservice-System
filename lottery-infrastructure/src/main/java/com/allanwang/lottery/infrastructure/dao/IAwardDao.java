package com.allanwang.lottery.infrastructure.dao;


import com.allanwang.lottery.infrastructure.po.Award;
import org.apache.ibatis.annotations.Mapper;
public interface IAwardDao {
    Award queryAwardInfo(String awardId);
}
