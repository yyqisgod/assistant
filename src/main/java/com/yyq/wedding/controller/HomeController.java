package com.yyq.wedding.controller;

import com.thoughtworks.xstream.XStream;
import com.yyq.wedding.domain.entity.Config;
import com.yyq.wedding.domain.entity.LuckDraw;
import com.yyq.wedding.domain.entity.Wechat;
import com.yyq.wedding.domain.message.ImageMessage;
import com.yyq.wedding.domain.message.InputMessage;
import com.yyq.wedding.domain.message.OutputMessage;
import com.yyq.wedding.service.ILuckDrawService;
import com.yyq.wedding.utils.EmojiUtil;
import com.yyq.wedding.utils.SHA1Util;
import com.yyq.wedding.utils.SerializeXmlUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class HomeController {

    private final ILuckDrawService luckDrawService;
    private final Config config;

    private static String text;
    private static String sendUsername;
    private static List<Long> codeList = new ArrayList<>();
    private static long currentTimeMillis;
    private static long endTime;

    @RequestMapping(value = "chat", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public void liaotian(Model model, HttpServletRequest request, HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        log.info("验证TOKEN" + config.getToken());
        boolean isGet = request.getMethod().toLowerCase().equals("get");
        if (isGet) {
            String signature = request.getParameter("signature");
            String timestamp = request.getParameter("timestamp");
            String nonce = request.getParameter("nonce");
            String echostr = request.getParameter("echostr");
            System.out.println(signature);
            System.out.println(timestamp);
            System.out.println(nonce);
            System.out.println(echostr);
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
        System.out.println("进入验证access");
        String signature = request.getParameter("signature");// 微信加密签名
        String timestamp = request.getParameter("timestamp");// 时间戳
        String nonce = request.getParameter("nonce");// 随机数
        String echostr = request.getParameter("echostr");// 随机字符串
        List<String> params = new ArrayList<String>();
        params.add(config.getToken());
        params.add(timestamp);
        params.add(nonce);
        // 1. 将token、timestamp、nonce三个参数进行字典序排序
        Collections.sort(params, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        // 2. 将三个参数字符串拼接成一个字符串进行sha1加密
        String temp = SHA1Util.encode(params.get(0) + params.get(1) + params.get(2));
        if (temp.equals(signature)) {
            try {
                response.getWriter().write(echostr);
                System.out.println("成功返回 echostr：" + echostr);
                return echostr;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //System.out.println("失败 认证");
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

        String servername = inputMsg.getToUserName();// 服务端
        String custermname = inputMsg.getFromUserName();// 客户端
        long createTime = inputMsg.getCreateTime();// 接收时间
        Long returnTime = Calendar.getInstance().getTimeInMillis() / 1000;// 返回时间

        // 取得消息类型
        String msgType = inputMsg.getMsgType();
        // 根据消息类型获取对应的消息内容
        sendUsername = inputMsg.getFromUserName();
        log.info("用户id=============" + sendUsername);
        log.info("发送信息内容=============" + inputMsg.getContent());
        text = inputMsg.getContent();
        if (text.contains("傻逼") || text.contains("白痴")) {
            text = "新婚快乐";
            String content = "婚礼现场！请注意您的素质！！";
            appendXML(response, servername, custermname, returnTime, msgType, content);
            return;
        }

        //抽奖一
        if (config.getLuckDrawTextOne().equals(text)) {
            if (currentTimeMillis <= endTime && currentTimeMillis != 0) {
                //判断该用户在该期间重复发送过指定弹幕没有，没有将抽奖码存入数据库并返回
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
            //将表情转换为弹幕
            equals100();
            text = "&nbsp" + text;
            str.append("<Content><![CDATA[弹幕\"" + textCode + "\"发送成功]]></Content>");
        }
        str.append("</xml>");
        response.getWriter().write(str.toString());

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

    private void replaceCode(String code) {
        if (text.contains(code)) {
            text = text.replace(code, EmojiUtil.getEmojiByWechat(code));
        }
    }

    private void appendXML(HttpServletResponse response, String servername, String custermname, Long returnTime, String msgType, String content) throws IOException {
        StringBuffer str = new StringBuffer();
        str.append("<xml>");
        str.append("<ToUserName><![CDATA[" + custermname + "]]></ToUserName>");
        str.append("<FromUserName><![CDATA[" + servername + "]]></FromUserName>");
        str.append("<CreateTime>" + returnTime + "</CreateTime>");
        str.append("<MsgType><![CDATA[" + msgType + "]]></MsgType>");
        str.append("<Content><![CDATA[" + content + "]]></Content>");
        str.append("</xml>");
        response.getWriter().write(str.toString());
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

    private void equals100() {
        replaceCode("/::)");
        replaceCode("/::~");
        replaceCode("/::B");
        replaceCode("/::|");
        replaceCode("/:8-");
        replaceCode("/::<");
        replaceCode("/::$");
        replaceCode("/::X");

        replaceCode("/::Z");
        replaceCode("/::'(");
        replaceCode("/::-|");
        replaceCode("/::@");
        replaceCode("/::P");
        replaceCode("/::D");
        replaceCode("/::O");
        replaceCode("/::(");

        replaceCode("[囧]");
        replaceCode("/::Q");
        replaceCode("/::T");
        replaceCode("/:,@P");
        replaceCode("/:,@-D");
        replaceCode("/::d");
        replaceCode("/:,@o");

        replaceCode("/:|-");
        replaceCode("/::!");
        replaceCode("/::L");
        replaceCode("/::>");
        replaceCode("/::,@");
        replaceCode("/:,@f");
        replaceCode("/::-S");
        replaceCode("/:?");

        replaceCode("/:,@x");
        replaceCode("/:,@@");
        replaceCode("/:,@!");
        replaceCode("/:!!!");
        replaceCode("/:xx");
        replaceCode("/:bye");
        replaceCode("/:wipe");
        replaceCode("/:dig");

        replaceCode("/:handclap");
        replaceCode("/:B-)");
        replaceCode("/:<@");
        replaceCode("/:@>");
        replaceCode("/::-O");
        replaceCode("/:>-|");
        replaceCode("/:P-(");

        replaceCode("/::'|");
        replaceCode("/:X-)");
        replaceCode("/::*");
        replaceCode("/:8*");
        replaceCode("/:pd");
        replaceCode("/:<W>");
        replaceCode("/:beer");
        replaceCode("/:coffee");

        replaceCode("/:pig");
        replaceCode("/:rose");
        replaceCode("/:fade");
        replaceCode("/:showlove");
        replaceCode("/:heart");
        replaceCode("/:break");
        replaceCode("/:cake");
        replaceCode("/:bome");

        replaceCode("/:shit");
        replaceCode("/:moon");
        replaceCode("/:sun");
        replaceCode("/:hug");
        replaceCode("/:strong");
        replaceCode("/:weak");
        replaceCode("/:share");

        replaceCode("/:v");
        replaceCode("/:@)");
        replaceCode("/:jj");
        replaceCode("/:@@");
        replaceCode("/:ok");
        replaceCode("/:jump");
        replaceCode("/:shake");
        replaceCode("/:<O>");

        replaceCode("/:circle");
        replaceCode("\uD83D\uDE04");
        replaceCode("\uD83D\uDE37");
        replaceCode("\uD83D\uDE02");
        replaceCode("\uD83D\uDE1D");
        replaceCode("\uD83D\uDE33");
        replaceCode("\uD83D\uDE31");
        replaceCode("\uD83D\uDE14");

        replaceCode("\uD83D\uDE12");
        replaceCode("[Hey]");
        replaceCode("[Facepalm]");
        replaceCode("[Smirk]");
        replaceCode("[Smart]");
        replaceCode("[Concerned]");
        replaceCode("[Yeah!]");

        replaceCode("\uD83D\uDC7B");
        replaceCode("\uD83D\uDE4F");
        replaceCode("\uD83D\uDCAA");
        replaceCode("\uD83C\uDF89");
        replaceCode("\uD83C\uDF81");
        replaceCode("[Packet]");
        replaceCode("[發]");
        replaceCode("[小狗]");
    }
}
