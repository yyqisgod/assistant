package com.yyq.wedding.controller;

import com.yyq.wedding.domain.pojo.Barrage;
import com.yyq.wedding.service.IBarrageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: 布里巴
 * @review:
 * @date: 2018/12/7
 */
@Api(description = "弹幕接口")
@RestController
@RequestMapping(value = "/barrage")
public class BarrageController {

    private final IBarrageService barrageService;

    @Autowired
    public BarrageController(final IBarrageService barrageService) {
        this.barrageService = barrageService;
    }

    @ApiOperation(value = "获取所有弹幕",httpMethod = "GET",response = Barrage.class)
    @GetMapping(value = "/list")
    public List<Barrage> list(){
        return barrageService.getBarrage();
    }

    @ApiOperation(value = "添加弹幕到数据库",httpMethod = "POST")
    @PostMapping( value = "/save")
    public void save(@RequestBody  Barrage barrage){
        barrageService.save(barrage);
    }
}
