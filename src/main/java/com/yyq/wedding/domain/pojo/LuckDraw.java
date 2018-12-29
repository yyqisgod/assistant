package com.yyq.wedding.domain.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: 布里巴
 * @review:
 * @date: 2018/12/29
 */
@Data
public class LuckDraw {

    @ApiModelProperty(value = "抽奖id")
    private Long id;

    @ApiModelProperty(value = "用户唯一Id")
    private String userId;
}
