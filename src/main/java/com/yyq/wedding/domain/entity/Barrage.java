package com.yyq.wedding.domain.entity;

import lombok.Data;

/**
 * @author: 布里巴
 * @review:
 * @date: 2018/12/7
 */
@Data
public class Barrage {
    /** 弹幕id */
    private Long id;
    /** 弹幕内容 */
    private String info;
    /** 弹幕颜色 */
    private String color;
    /** 头像 */
    private String img;
    /** 点击弹幕跳转路径*/
    private String href;
    /** 弹幕速度 */
    private String speed;
}
