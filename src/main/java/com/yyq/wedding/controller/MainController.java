package com.yyq.wedding.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: 布里巴
 * @review:
 * @date: 2018/12/7
 */
@Controller
@Api(description = "跳转主页接口")
public class MainController {

    @ApiOperation(value = "跳转主页")
    @GetMapping(value = "/main")
    public String main(){
        return "index";
    }
}
