package com.yyq.wedding.domain.entity;

import com.yyq.wedding.factory.ConfigFactory;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


@ConfigurationProperties(prefix = "wedding")
@Data
@PropertySource(value = "classpath:config.yml", factory = ConfigFactory.class)
@Component
public class Config {

    /** 微信token全局配置*/
    private String token;

    /** 指定抽奖一持续时间*/
    private Long luckDrawTimeOne;

    /** 指定抽奖一需要发送的弹幕*/
    private String luckDrawTextOne;
}
