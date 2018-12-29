package com.yyq.wedding.service.impl;

import com.yyq.wedding.dao.LuckDrawMapper;
import com.yyq.wedding.domain.pojo.LuckDraw;
import com.yyq.wedding.service.ILuckDrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: 布里巴
 * @review:
 * @date: 2018/12/29
 */
@Service
public class LuckDrawServiceImpl implements ILuckDrawService {

    private final LuckDrawMapper luckDrawMapper;

    @Autowired
    public LuckDrawServiceImpl(LuckDrawMapper luckDrawMapper) {
        this.luckDrawMapper = luckDrawMapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int lotteryCode(String userId) {
        LuckDraw luckDrawOne = luckDrawMapper.getOneByUserId(userId);
        if (luckDrawOne == null){
            //添加到数据库并返回对应id
            return luckDrawMapper.save(userId);
        }
        return -1;
    }
}
