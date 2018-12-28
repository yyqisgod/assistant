package com.yyq.wedding.service;

import com.yyq.wedding.domain.pojo.Barrage;

import java.util.List;

/**
 * 弹幕相关方法
 *
 * @author: 布里巴
 * @review:
 * @date: 2018/12/7
 */
public interface IBarrageService {
    /**
     *获取所有弹幕信息
     *
     * @return 弹幕列表
     */
    List<Barrage> getBarrage();

    /**
     *保存新发弹幕
     *
     */
    void save(Barrage barrage);
}
