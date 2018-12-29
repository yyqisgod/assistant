package com.yyq.wedding.dao;

import com.yyq.wedding.domain.pojo.LuckDraw;
import org.springframework.stereotype.Repository;

/**
 * @author: 布里巴
 * @review:
 * @date: 2018/12/29
 */
@Repository
public interface LuckDrawMapper {
    /**
     * 根据用户id获取抽奖码
     * @return
     */
    LuckDraw getOneByUserId(LuckDraw luckDraw);

    /**
     * 将用户id存入数据库并返回对应的id
     * @param luckDraw
     */
    int save(LuckDraw luckDraw);
}
