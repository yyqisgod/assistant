# wedding
婚庆大屏和微信端互动，关注个人微信公众号发送消息，再大屏通过弹幕的形式展示你发送的消息，并且可以通过发送弹幕的形式参与抽奖

## 项目架构
本项目架构springboot 持久采用mybatis 

## 项目配置:
maven:3.3.9 tomcat:8.5  jdk:1.8 项目clone推荐采用IDEA

## 实现个性化配置
* 将application.yml配置自己的数据库<br>
* config.yml中配置token并在com.yyq.wedding.wechat.HomeController中验证自己的Token然后请求接口<br>
* 音乐播放器chome如果出现报错 ：<br>
    > 在浏览器输入  chrome://flags/#autoplay-policy <br>
    >> 第一个选项 Autoplay policy  设置为 no user gesture is required <br>
* logback日志说明 ：<br>
    > logback-spring.xml中自定义springProfile的level------>>目前默认输出为Info级别<br>
    >> STDOUT为输出到控制台 fileInfoLog为引用上面的日志输出路径
    >>> application.yml中profiles指定输出的类型
## 开发环境
    目前均在dev分支开发，再合并到master
    
    
    
    ![image](https://github.com/yyqisgod/wedding/blob/master/images/heiheihei.png)





                                                                    本项目架构师----yyq
                                                                    后勤维护----yl
                                                                    项目总监----wuchun
