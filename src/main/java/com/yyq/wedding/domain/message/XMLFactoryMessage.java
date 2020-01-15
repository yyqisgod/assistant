package com.yyq.wedding.domain.message;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: 布里巴
 * @review:
 * @date: 2020/1/14
 */
public class XMLFactoryMessage {

    private StringBuilder sb;
    private HttpServletResponse response;

    private XMLFactoryMessage(HttpServletResponse response) {
        this.response = response;
        sb = new StringBuilder("<xml>");
    }

    public static XMLFactoryMessage builder(HttpServletResponse response) {
        return new XMLFactoryMessage(response);
    }

    public XMLFactoryMessage custermname(String custermname) {
        sb.append("<ToUserName><![CDATA[").append(custermname).append("]]></ToUserName>");
        return this;
    }

    public XMLFactoryMessage servername(String servername) {
        sb.append("<FromUserName><![CDATA[").append(servername).append("]]></FromUserName>");
        return this;
    }

    public XMLFactoryMessage returnTime(Long returnTime) {
        sb.append("<CreateTime>").append(returnTime).append("</CreateTime>");
        return this;
    }

    public XMLFactoryMessage msgType(String msgType) {
        sb.append("<MsgType><![CDATA[").append(msgType).append("]]></MsgType>");
        return this;
    }

    public XMLFactoryMessage content(String content) {
        sb.append("<Content><![CDATA[").append(content).append("]]></Content>");
        return this;
    }

    public void build() throws IOException {
        sb.append("</xml>");
        response.getWriter().write(sb.toString());
    }
}
