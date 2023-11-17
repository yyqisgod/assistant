package com.yyq.wedding.controller;

import com.thoughtworks.xstream.XStream;
import com.yyq.wedding.domain.entity.Config;
import com.yyq.wedding.domain.entity.LuckDraw;
import com.yyq.wedding.domain.entity.Wechat;
import com.yyq.wedding.domain.message.ImageMessage;
import com.yyq.wedding.domain.message.InputMessage;
import com.yyq.wedding.domain.message.OutputMessage;
import com.yyq.wedding.domain.message.XMLFactoryMessage;
import com.yyq.wedding.service.ILuckDrawService;
import com.yyq.wedding.service.WebSocketService;
import com.yyq.wedding.utils.EmojiUtil;
import com.yyq.wedding.utils.SHA1Util;
import com.yyq.wedding.utils.SensitiveUnit;
import com.yyq.wedding.utils.SerializeXmlUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@Controller
@Slf4j
@RequestMapping("/wwsw")
@RequiredArgsConstructor
public class WeChatController {

    private final ILuckDrawService luckDrawService;
    private final Config config;
    private final WebSocketService webSocketService;

    private String token = "wxed71f0accde4d94e";

    private static String text;
    private static String sendUsername;
    private static List<Long> codeList = new ArrayList<>();
    private static long currentTimeMillis;
    private static long endTime;

    @RequestMapping(value = "chat", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public void liaotian(HttpServletRequest request, HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        boolean isGet = request.getMethod().toLowerCase().equals("get");
        if (isGet) {
            access(request, response);
        } else {
            // 进入POST聊天处理
            try {
                // 接收消息并返回消息
                acceptMessage(request, response);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 验证URL真实性
     *
     * @param request
     * @param response
     * @return String
     * @author morning
     * @date 2015年2月17日 上午10:53:07
     */
    private String access(HttpServletRequest request, HttpServletResponse response) {
        // 验证URL真实性
        log.info("进入验证access");
        // 微信加密签名
        String signature = request.getParameter("signature");
        // 时间戳
        String timestamp = request.getParameter("timestamp");
        // 随机数
        String nonce = request.getParameter("nonce");
        // 随机字符串
        String echostr = request.getParameter("echostr");
        List<String> params = new ArrayList<String>();
        params.add(token);
        params.add(timestamp);
        params.add(nonce);
        // 1. 将token、timestamp、nonce三个参数进行字典序排序
        params.sort(String::compareTo);
        // 2. 将三个参数字符串拼接成一个字符串进行sha1加密
        String temp = SHA1Util.encode(params.get(0) + params.get(1) + params.get(2));
        if (temp.equals(signature)) {
            try {
                response.getWriter().write(echostr);
                log.info("认证成功 echostr：{}", echostr);
                return echostr;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        log.info("认证失败");
        return null;
    }

    private void acceptMessage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 处理接收消息
        ServletInputStream in = request.getInputStream();
        // 将POST流转换为XStream对象
        XStream xs = SerializeXmlUtil.createXstream();
        xs.processAnnotations(InputMessage.class);
        xs.processAnnotations(OutputMessage.class);
        // 将指定节点下的xml节点数据映射为对象
        xs.alias("xml", InputMessage.class);
        // 将流转换为字符串
        StringBuilder xmlMsg = new StringBuilder();
        byte[] b = new byte[4096];
        for (int n; (n = in.read(b)) != -1; ) {
            xmlMsg.append(new String(b, 0, n, "UTF-8"));
        }
        // 将xml内容转换为InputMessage对象
        InputMessage inputMsg = (InputMessage) xs.fromXML(xmlMsg.toString());

        // 服务端
        String servername = inputMsg.getToUserName();
        // 客户端
        String custermname = inputMsg.getFromUserName();
        // 返回时间
        Long returnTime = Calendar.getInstance().getTimeInMillis() / 1000;

        // 取得消息类型
        String msgType = inputMsg.getMsgType();
        // 根据消息类型获取对应的消息内容
        sendUsername = inputMsg.getFromUserName();
        log.info("用户id=============" + sendUsername);
        log.info("发送信息内容=============" + inputMsg.getContent());
        text = inputMsg.getContent();

        // 如果含有敏感词，替换成新婚可能
        if (SensitiveUnit.isSensitive(text)) {
            text = "新婚快乐";
            String content = "婚礼期间请注意言辞";
            appendXML(response, servername, custermname, returnTime, msgType, content);
            return;
        }

        // 抽奖一
        if (config.getLuckDrawTextOne().equals(text)) {
            if (currentTimeMillis <= endTime && currentTimeMillis != 0) {
                // 判断该用户在该期间重复发送过指定弹幕没有，没有将抽奖码存入数据库并返回
                LuckDraw luckDraw = new LuckDraw();
                luckDraw.setUserId(sendUsername);
                long code = luckDrawService.lotteryCode(luckDraw);
                if (code != -1) {
                    String content = "感谢你的祝福，你的抽奖码是\"" + code + "\"，请妥善保存";
                    appendXML(response, servername, custermname, returnTime, msgType, content);
                    codeList.add(code);
                } else {
                    String content = "活动期间抽奖码只能获取一次哦";
                    appendXML(response, servername, custermname, returnTime, msgType, content);
                }
                return;
            } else {
                String content = "未到抽奖时间，不能参与抽奖，请到时准时参与";
                appendXML(response, servername, custermname, returnTime, msgType, content);
                return;
            }
        }

        StringBuffer str = new StringBuffer();
        str.append("<xml>");
        str.append("<ToUserName><![CDATA[" + custermname + "]]></ToUserName>");
        str.append("<FromUserName><![CDATA[" + servername + "]]></FromUserName>");
        str.append("<CreateTime>" + returnTime + "</CreateTime>");
        str.append("<MsgType><![CDATA[" + msgType + "]]></MsgType>");
        if (text.contains("收到不支持的消息类型，暂无法显示")) {
            str.append("<Content><![CDATA[暂时不支持发送表情弹幕]]></Content>");
            text = "新婚快乐";
        } else {
            String textCode = text;
            // 将表情转换为弹幕
            text = EmojiUtil.formatEmojiImg(text);
            str.append("<Content><![CDATA[弹幕\"" + textCode + "\"发送成功]]></Content>");
        }
        str.append("</xml>");
        response.getWriter().write(str.toString());

        webSocketService.sendMessage(text);

        OutputMessage outputMsg = new OutputMessage();
        outputMsg.setFromUserName(servername);
        outputMsg.setToUserName(custermname);
        outputMsg.setCreateTime(returnTime);
        outputMsg.setMsgType(msgType);
        ImageMessage images = new ImageMessage();
        images.setMediaId(inputMsg.getMediaId());
        outputMsg.setImage(images);
        response.getWriter().write(xs.toXML(outputMsg));
    }

    /**
     * 公众号回复消息
     *
     * @throws IOException
     */
    private void appendXML(HttpServletResponse response, String servername, String custermname, Long returnTime, String msgType, String content) throws IOException {
        XMLFactoryMessage.builder(response)
                .content(content)
                .custermname(custermname)
                .msgType(msgType)
                .returnTime(returnTime)
                .servername(servername)
                .build();
    }

    @RequestMapping("/sendText")
    @ResponseBody
    public Wechat sendText() {
        Wechat wechat = new Wechat();
        wechat.setText(text);
        wechat.setUserId(sendUsername);
        return wechat;
    }

    @RequestMapping("/getCode")
    @ResponseBody
    public Map<String, Object> getCode() throws InterruptedException {
        for (int i = 0; i < config.getLuckDrawTimeOne(); i++) {
            currentTimeMillis = System.currentTimeMillis();
            if (i == 0) {
                endTime = currentTimeMillis + (config.getLuckDrawTimeOne() - 1) * 1000;
            }
            Thread.sleep(1000);
        }
        Map<String, Object> map = new HashMap<>(3);
        Collections.shuffle(codeList);
        map.put("id", codeList);
        return map;
    }

    @RequestMapping("/msg")
    @ResponseBody
    public Map<String, Object> msg() {
        Map<String, Object> map = new HashMap<>(2);
        map.put("name", config.getLuckDrawTextOne());
        map.put("time", config.getLuckDrawTimeOne());
        return map;
    }
}
