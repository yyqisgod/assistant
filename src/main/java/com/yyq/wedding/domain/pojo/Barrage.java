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
    private String text;
    @ApiModelProperty(value = "弹幕颜色")
    private String color;
    @ApiModelProperty(value = "弹幕位置，0为滚动，1为顶部，2为底部")
    private Integer position;
    @ApiModelProperty(value = "弹幕文字大小，0为小字，1为大字")
    private Integer size;
    @ApiModelProperty(value = "弹幕出现时间，单位为分秒(十分之一秒)")
    private Long time;
}
