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
        map.put("/::)", "<img src='imgs/emoji/1-1-1.png' style='width: 20px'>");
        map.put("/::~", "<img src='imgs/emoji/1-1-2.png' style='width: 20px'>");
        map.put("/::B", "<img src='imgs/emoji/1-1-3.png' style='width: 20px'>");
        map.put("/::|", "<img src='imgs/emoji/1-1-4.png' style='width: 20px'>");
        map.put("/:8-", "<img src='imgs/emoji/1-1-5.png' style='width: 20px'>");
        map.put("/::<", "<img src='imgs/emoji/1-1-6.png' style='width: 20px'>");
        map.put("/::$", "<img src='imgs/emoji/1-1-7.png' style='width: 20px'>");
        map.put("/::X", "<img src='imgs/emoji/1-1-8.png' style='width: 20px'>");

        map.put("/::Z", "<img src='imgs/emoji/1-2-1.png' style='width: 20px'>");
        map.put("/::'(", "<img src='imgs/emoji/1-2-2.png' style='width: 20px'>");
        map.put("/::-|", "<img src='imgs/emoji/1-2-3.png' style='width: 20px'>");
        map.put("/::@", "<img src='imgs/emoji/1-2-4.png' style='width: 20px'>");
        map.put("/::P", "<img src='imgs/emoji/1-2-5.png' style='width: 20px'>");
        map.put("/::D", "<img src='imgs/emoji/1-2-6.png' style='width: 20px'>");
        map.put("/::O", "<img src='imgs/emoji/1-2-7.png' style='width: 20px'>");
        map.put("/::(", "<img src='imgs/emoji/1-2-8.png' style='width: 20px'>");

        map.put("[囧]", "<img src='imgs/emoji/1-3-1.png' style='width: 20px'>");
        map.put("/::Q", "<img src='imgs/emoji/1-3-2.png' style='width: 20px'>");
        map.put("/::T", "<img src='imgs/emoji/1-3-3.png' style='width: 20px'>");
        map.put("/:,@P", "<img src='imgs/emoji/1-3-4.png' style='width: 20px'>");
        map.put("/:,@-D", "<img src='imgs/emoji/1-3-5.png' style='width: 20px'>");
        map.put("/::d", "<img src='imgs/emoji/1-3-6.png' style='width: 20px'>");
        map.put("/:,@o", "<img src='imgs/emoji/1-3-7.png' style='width: 20px'>");

        map.put("/:|-", "<img src='imgs/emoji/2-1-1.png' style='width: 20px'>");
        map.put("/::!", "<img src='imgs/emoji/2-1-2.png' style='width: 20px'>");
        map.put("/::L", "<img src='imgs/emoji/2-1-3.png' style='width: 20px'>");
        map.put("/::>", "<img src='imgs/emoji/2-1-4.png' style='width: 20px'>");
        map.put("/::,@", "<img src='imgs/emoji/2-1-5.png' style='width: 20px'>");
        map.put("/:,@f", "<img src='imgs/emoji/2-1-6.png' style='width: 20px'>");
        map.put("/::-S", "<img src='imgs/emoji/2-1-7.png' style='width: 20px'>");
        map.put("/:?", "<img src='imgs/emoji/2-1-8.png' style='width: 20px'>");

        map.put("/:,@x", "<img src='imgs/emoji/2-2-1.png' style='width: 20px'>");
        map.put("/:,@@", "<img src='imgs/emoji/2-2-2.png' style='width: 20px'>");
        map.put("/:,@!", "<img src='imgs/emoji/2-2-3.png' style='width: 20px'>");
        map.put("/:!!!", "<img src='imgs/emoji/2-2-4.png' style='width: 20px'>");
        map.put("/:xx", "<img src='imgs/emoji/2-2-5.png' style='width: 20px'>");
        map.put("/:bye", "<img src='imgs/emoji/2-2-6.png' style='width: 20px'>");
        map.put("/:wipe", "<img src='imgs/emoji/2-2-7.png' style='width: 20px'>");
        map.put("/:dig", "<img src='imgs/emoji/2-2-8.png' style='width: 20px'>");

        map.put("/:handclap", "<img src='imgs/emoji/2-3-1.png' style='width: 20px'>");
        map.put("/:B-)", "<img src='imgs/emoji/2-3-2.png' style='width: 20px'>");
        map.put("/:<@", "<img src='imgs/emoji/2-3-3.png' style='width: 20px'>");
        map.put("/:@>", "<img src='imgs/emoji/2-3-4.png' style='width: 20px'>");
        map.put("/::-O", "<img src='imgs/emoji/2-3-5.png' style='width: 20px'>");
        map.put("/:>-|", "<img src='imgs/emoji/2-3-6.png' style='width: 20px'>");
        map.put("/:P-(", "<img src='imgs/emoji/2-3-7.png' style='width: 20px'>");

        map.put("/::'|", "<img src='imgs/emoji/3-1-1.png' style='width: 20px'>");
        map.put("/:X-)", "<img src='imgs/emoji/3-1-2.png' style='width: 20px'>");
        map.put("/::*", "<img src='imgs/emoji/3-1-3.png' style='width: 20px'>");
        map.put("/:8*", "<img src='imgs/emoji/3-1-4.png' style='width: 20px'>");
        map.put("/:pd", "<img src='imgs/emoji/3-1-5.png' style='width: 20px'>");
        map.put("/:<W>", "<img src='imgs/emoji/3-1-6.png' style='width: 20px'>");
        map.put("/:beer", "<img src='imgs/emoji/3-1-7.png' style='width: 20px'>");
        map.put("/:coffee", "<img src='imgs/emoji/3-1-8.png' style='width: 20px'>");

        map.put("/:pig", "<img src='imgs/emoji/3-2-1.png' style='width: 20px'>");
        map.put("/:rose", "<img src='imgs/emoji/3-2-2.png' style='width: 20px'>");
        map.put("/:fade", "<img src='imgs/emoji/3-2-3.png' style='width: 20px'>");
        map.put("/:showlove", "<img src='imgs/emoji/3-2-4.png' style='width: 20px'>");
        map.put("/:heart", "<img src='imgs/emoji/3-2-5.png' style='width: 20px'>");
        map.put("/:break", "<img src='imgs/emoji/3-2-6.png' style='width: 20px'>");
        map.put("/:cake", "<img src='imgs/emoji/3-2-7.png' style='width: 20px'>");
        map.put("/:bome", "<img src='imgs/emoji/3-2-8.png' style='width: 20px'>");

        map.put("/:shit", "<img src='imgs/emoji/3-3-1.png' style='width: 20px'>");
        map.put("/:moon", "<img src='imgs/emoji/3-3-2.png' style='width: 20px'>");
        map.put("/:sun", "<img src='imgs/emoji/3-3-3.png' style='width: 20px'>");
        map.put("/:hug", "<img src='imgs/emoji/3-3-4.png' style='width: 20px'>");
        map.put("/:strong", "<img src='imgs/emoji/3-3-5.png' style='width: 20px'>");
        map.put("/:weak", "<img src='imgs/emoji/3-3-6.png' style='width: 20px'>");
        map.put("/:share", "<img src='imgs/emoji/3-3-7.png' style='width: 20px'>");

        map.put("/:v", "<img src='imgs/emoji/4-1-1.png' style='width: 20px'>");
        map.put("/:@)", "<img src='imgs/emoji/4-1-2.png' style='width: 20px'>");
        map.put("/:jj", "<img src='imgs/emoji/4-1-3.png' style='width: 20px'>");
        map.put("/:@@", "<img src='imgs/emoji/4-1-4.png' style='width: 20px'>");
        map.put("/:ok", "<img src='imgs/emoji/4-1-5.png' style='width: 20px'>");
        map.put("/:jump", "<img src='imgs/emoji/4-1-6.png' style='width: 20px'>");
        map.put("/:shake", "<img src='imgs/emoji/4-1-7.png' style='width: 20px'>");
        map.put("/:<O>", "<img src='imgs/emoji/4-1-8.png' style='width: 20px'>");

        map.put("/:circle", "<img src='imgs/emoji/4-2-1.png' style='width: 20px'>");
        map.put("\uD83D\uDE04", "<img src='imgs/emoji/4-2-2.png' style='width: 20px'>");
        map.put("\uD83D\uDE37", "<img src='imgs/emoji/4-2-3.png' style='width: 20px'>");
        map.put("\uD83D\uDE02", "<img src='imgs/emoji/4-2-4.png' style='width: 20px'>");
        map.put("\uD83D\uDE1D", "<img src='imgs/emoji/4-2-5.png' style='width: 20px'>");
        map.put("\uD83D\uDE33", "<img src='imgs/emoji/4-2-6.png' style='width: 20px'>");
        map.put("\uD83D\uDE31", "<img src='imgs/emoji/4-2-7.png' style='width: 20px'>");
        map.put("\uD83D\uDE14", "<img src='imgs/emoji/4-2-8.png' style='width: 20px'>");

        map.put("\uD83D\uDE12", "<img src='imgs/emoji/4-3-1.png' style='width: 20px'>");
        map.put("[Hey]", "<img src='imgs/emoji/4-3-2.png' style='width: 20px'>");
        map.put("[Facepalm]", "<img src='imgs/emoji/4-3-3.png' style='width: 20px'>");
        map.put("[Smirk]", "<img src='imgs/emoji/4-3-4.png' style='width: 20px'>");
        map.put("[Smart]", "<img src='imgs/emoji/4-3-5.png' style='width: 20px'>");
        map.put("[Concerned]", "<img src='imgs/emoji/4-3-6.png' style='width: 20px'>");
        map.put("[Yeah!]", "<img src='imgs/emoji/4-3-7.png' style='width: 20px'>");

        map.put("\uD83D\uDC7B", "<img src='imgs/emoji/5-1-1.png' style='width: 20px'>");
        map.put("\uD83D\uDE4F", "<img src='imgs/emoji/5-1-2.png' style='width: 20px'>");
        map.put("\uD83D\uDCAA", "<img src='imgs/emoji/5-1-3.png' style='width: 20px'>");
        map.put("\uD83C\uDF89", "<img src='imgs/emoji/5-1-4.png' style='width: 20px'>");
        map.put("\uD83C\uDF81", "<img src='imgs/emoji/5-1-5.png' style='width: 20px'>");
        map.put("[Packet]", "<img src='imgs/emoji/5-1-6.png' style='width: 20px'>");
        map.put("[發]", "<img src='imgs/emoji/5-1-7.png' style='width: 20px'>");
        map.put("[小狗]", "<img src='imgs/emoji/5-1-8.png' style='width: 20px'>");

        return map.get(code);
    }
}
