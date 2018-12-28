package com.yyq.wedding.domain.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "wedding")
@Data
@PropertySource("config.yml")
public class Config {
    @ApiModelProperty(value = "微信token全局配置")
    private String token;
}
