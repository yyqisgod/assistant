package com.yyq.wedding.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author YangLiu
 * @Title: SecurityConfig
 * @ProjectName wedding
 * @Description: TODO
 * @date 2019/1/411:11
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login")
                .loginProcessingUrl("/form")
                .defaultSuccessUrl("/wedding.jsp")
                .failureUrl("/login")
                //成功后跳转。。。
                .permitAll()
                .and()
                //关闭csrf
                .csrf().disable()
        ;

    }
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(new String[]{"/oracle/**","login"});

        //可以仿照上面一句忽略静态资源
    }



}
