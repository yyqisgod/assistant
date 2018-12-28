package com.yyq.wedding.dao;

import com.yyq.wedding.domain.pojo.Barrage;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 弹幕
 *
 * @author: 布里巴
 * @review:
 * @date: 2018/12/7
 */
@Repository
public interface BarrageMapper {
    /**
     * 获取弹幕信息
     *
     * @return 弹幕信息列表
     */
    List<Barrage> getBarrage();

    /**
     * 保存弹幕信息
     *
     */
    void save(Barrage barrage);
}
