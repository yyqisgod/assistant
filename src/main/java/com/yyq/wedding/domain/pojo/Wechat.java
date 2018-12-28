package com.yyq.wedding.domain.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Wechat {
    @ApiModelProperty(value = "微信获取到的文本信息")
    private String text;
    @ApiModelProperty(value = "微信获取到的用户id")
    private String userId;
}
