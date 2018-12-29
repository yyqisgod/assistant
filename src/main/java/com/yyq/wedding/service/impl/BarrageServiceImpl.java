package com.yyq.wedding.service.impl;

import com.yyq.wedding.dao.BarrageMapper;
import com.yyq.wedding.domain.pojo.Barrage;
import com.yyq.wedding.service.IBarrageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 弹幕方法实现类
 *
 * @author: 布里巴
 * @review:
 * @date: 2018/12/7
 */
@Service
public class BarrageServiceImpl implements IBarrageService {

    private final BarrageMapper barrageMapper;

    @Autowired
    public BarrageServiceImpl(final BarrageMapper barrageMapper) {
        this.barrageMapper = barrageMapper;
    }

    @Override
    public List<Barrage> getBarrage() {
        return barrageMapper.getBarrage();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(Barrage barrage) {
        barrageMapper.save(barrage);
    }
}
