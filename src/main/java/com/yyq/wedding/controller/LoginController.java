package com.yyq.wedding.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author YangLiu
 * @Title: LoginController
 * @ProjectName wedding
 * @Description: TODO
 * @date 2019/1/411:13
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    @RequestMapping("")
    public String login(){
        return "login";
    }
}
