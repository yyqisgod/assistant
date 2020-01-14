package com.yyq.wedding.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: 布里巴
 * @review:
 * @date: 2018/12/7
 *
 * 跳转主页接口
 */
@Controller
public class MainController {

    /**
     * 跳转主页
     * @return
     */
    @GetMapping(value = "/main")
    public String main(){
        return "index";
    }
}
