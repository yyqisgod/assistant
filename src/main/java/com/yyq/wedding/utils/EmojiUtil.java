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
        return map.get(code);
    }
}
