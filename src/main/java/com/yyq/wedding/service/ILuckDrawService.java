package com.yyq.wedding.service;

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
    int lotteryCode(String userId);
}
