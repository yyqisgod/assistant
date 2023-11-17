package com.yyq.wedding.domain.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@ConfigurationProperties(prefix = "wedding")
@Data
@Configuration
public class Config {

    /**
     * 指定抽奖一持续时间
     */
    private Long luckDrawTimeOne;

    /**
     * 指定抽奖一需要发送的弹幕
     */
    private String luckDrawTextOne;
}
