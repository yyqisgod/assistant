package com.yyq.wedding.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: 布里巴
 * @review:
 * @date: 2019/1/11
 */
public class EmojiUtil {
    /**
     * 微信表情编码转换为微信表情
     * @param code 表情编码
     * @return 表情路径
     */
    public static String getEmojiByWechat(String code){
        Map<String,String> map = new HashMap<>();
        map.put("/::)", "<img src='imgs/emoji/1-1-1.png' style='width: 25px'>");
        map.put("/::~", "<img src='imgs/emoji/1-1-2.png' style='width: 25px'>");
        map.put("/::B", "<img src='imgs/emoji/1-1-3.png' style='width: 25px'>");
        map.put("/::|", "<img src='imgs/emoji/1-1-4.png' style='width: 25px'>");
        map.put("/:8-", "<img src='imgs/emoji/1-1-5.png' style='width: 25px'>");
        map.put("/::<", "<img src='imgs/emoji/1-1-6.png' style='width: 25px'>");
        map.put("/::$", "<img src='imgs/emoji/1-1-7.png' style='width: 25px'>");
        map.put("/::X", "<img src='imgs/emoji/1-1-8.png' style='width: 25px'>");



        map.put("/::Z", "<img src='imgs/emoji/1-2-1.png' style='width: 25px'>");
        map.put("/::'(", "<img src='imgs/emoji/1-2-2.png' style='width: 25px'>");
        map.put("/::-|", "<img src='imgs/emoji/1-2-3.png' style='width: 25px'>");
        map.put("/::@", "<img src='imgs/emoji/1-2-4.png' style='width: 25px'>");
        map.put("/::P", "<img src='imgs/emoji/1-2-5.png' style='width: 25px'>");
        map.put("/::D", "<img src='imgs/emoji/1-2-6.png' style='width: 25px'>");
        map.put("/::O", "<img src='imgs/emoji/1-2-7.png' style='width: 25px'>");
        map.put("/::(", "<img src='imgs/emoji/1-2-8.png' style='width: 25px'>");

        map.put("/::+", "<img src='imgs/emoji/1-1-5.png' style='width: 25px'>");
        map.put("[囧]", "<img src='imgs/emoji/1-3-1.png' style='width: 25px'>");
        map.put("/::Q", "<img src='imgs/emoji/1-3-2.png' style='width: 25px'>");
        map.put("/::T", "<img src='imgs/emoji/1-3-3.png' style='width: 25px'>");
        map.put("/:,@P", "<img src='imgs/emoji/1-3-4.png' style='width: 25px'>");
        map.put("/:,@-D", "<img src='imgs/emoji/1-3-5.png' style='width: 25px'>");
        map.put("/::d", "<img src='imgs/emoji/1-3-6.png' style='width: 25px'>");
        map.put("/:,@o", "<img src='imgs/emoji/1-3-7.png' style='width: 25px'>");
        map.put("/::g", "？？？？？？？？？？？？"); //没有这个表情


        return map.get(code);
    }
}
