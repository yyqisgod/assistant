package com.yyq.wedding.domain.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: 布里巴
 * @review:
 * @date: 2018/12/7
 */
@Data
public class Barrage {
    @ApiModelProperty(value = "弹幕Id")
    private Long id;
    @ApiModelProperty(value = "弹幕内容")
    private String info;
    @ApiModelProperty(value = "弹幕颜色")
    private String color;
    @ApiModelProperty(value = "头像")
    private String img;
    @ApiModelProperty(value = "点击弹幕跳转路径")
    private String href;
    @ApiModelProperty(value = "弹幕速度")
    private String speed;
}
