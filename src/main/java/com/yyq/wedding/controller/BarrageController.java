package com.yyq.wedding.controller;

import com.yyq.wedding.domain.entity.Barrage;
import com.yyq.wedding.service.IBarrageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: 布里巴
 * @review:
 * @date: 2018/12/7
 *
 * 弹幕接口
 */
@RestController
@RequestMapping(value = "/barrage")
public class BarrageController {

    private final IBarrageService barrageService;

    @Autowired
    public BarrageController(final IBarrageService barrageService) {
        this.barrageService = barrageService;
    }

    /**
     * 获取所有弹幕
     * @return
     */
    @GetMapping(value = "/list")
    public List<Barrage> list(){
        return barrageService.getBarrage();
    }

    /**
     * 添加弹幕到数据库
     * @param barrage
     */
    @PostMapping( value = "/save")
    public void save(@RequestBody  Barrage barrage){
        barrageService.save(barrage);
    }
}
