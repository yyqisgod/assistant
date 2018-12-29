package com.yyq.wedding.service;

import com.yyq.wedding.domain.pojo.LuckDraw;

/**
 * @author: 布里巴
 * @review:
 * @date: 2018/12/29
 */
public interface ILuckDrawService {
    /**
     * 获取抽奖一的抽奖码
     * @return
     */
    long lotteryCode(LuckDraw luckDraw);
}
