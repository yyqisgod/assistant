package com.yyq.wedding.domain.entity;

import lombok.Data;

@Data
public class Wechat {

    /** 微信获取到的文本信息 */
    private String text;

    /** 微信获取到的用户id */
    private String userId;
}
