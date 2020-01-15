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
     * 初始化表情库
     */
    private static Map<String, String> map = new HashMap<>();

    static {
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
    }

    /**
     * 表情字符转换成表情图片
     */
    public static String formatEmojiImg(String text) {
        text = replaceCode(text, "/::)");
        text = replaceCode(text, "/::~");
        text = replaceCode(text, "/::B");
        text = replaceCode(text, "/::|");
        text = replaceCode(text, "/:8-");
        text = replaceCode(text, "/::<");
        text = replaceCode(text, "/::$");
        text = replaceCode(text, "/::X");

        text = replaceCode(text, "/::Z");
        text = replaceCode(text, "/::'(");
        text = replaceCode(text, "/::-|");
        text = replaceCode(text, "/::@");
        text = replaceCode(text, "/::P");
        text = replaceCode(text, "/::D");
        text = replaceCode(text, "/::O");
        text = replaceCode(text, "/::(");

        text = replaceCode(text, "[囧]");
        text = replaceCode(text, "/::Q");
        text = replaceCode(text, "/::T");
        text = replaceCode(text, "/:,@P");
        text = replaceCode(text, "/:,@-D");
        text = replaceCode(text, "/::d");
        text = replaceCode(text, "/:,@o");

        text = replaceCode(text, "/:|-");
        text = replaceCode(text, "/::!");
        text = replaceCode(text, "/::L");
        text = replaceCode(text, "/::>");
        text = replaceCode(text, "/::,@");
        text = replaceCode(text, "/:,@f");
        text = replaceCode(text, "/::-S");
        text = replaceCode(text, "/:?");

        text = replaceCode(text, "/:,@x");
        text = replaceCode(text, "/:,@@");
        text = replaceCode(text, "/:,@!");
        text = replaceCode(text, "/:!!!");
        text = replaceCode(text, "/:xx");
        text = replaceCode(text, "/:bye");
        text = replaceCode(text, "/:wipe");
        text = replaceCode(text, "/:dig");

        text = replaceCode(text, "/:handclap");
        text = replaceCode(text, "/:B-)");
        text = replaceCode(text, "/:<@");
        text = replaceCode(text, "/:@>");
        text = replaceCode(text, "/::-O");
        text = replaceCode(text, "/:>-|");
        text = replaceCode(text, "/:P-(");

        text = replaceCode(text, "/::'|");
        text = replaceCode(text, "/:X-)");
        text = replaceCode(text, "/::*");
        text = replaceCode(text, "/:8*");
        text = replaceCode(text, "/:pd");
        text = replaceCode(text, "/:<W>");
        text = replaceCode(text, "/:beer");
        text = replaceCode(text, "/:coffee");

        text = replaceCode(text, "/:pig");
        text = replaceCode(text, "/:rose");
        text = replaceCode(text, "/:fade");
        text = replaceCode(text, "/:showlove");
        text = replaceCode(text, "/:heart");
        text = replaceCode(text, "/:break");
        text = replaceCode(text, "/:cake");
        text = replaceCode(text, "/:bome");

        text = replaceCode(text, "/:shit");
        text = replaceCode(text, "/:moon");
        text = replaceCode(text, "/:sun");
        text = replaceCode(text, "/:hug");
        text = replaceCode(text, "/:strong");
        text = replaceCode(text, "/:weak");
        text = replaceCode(text, "/:share");

        text = replaceCode(text, "/:v");
        text = replaceCode(text, "/:@)");
        text = replaceCode(text, "/:jj");
        text = replaceCode(text, "/:@@");
        text = replaceCode(text, "/:ok");
        text = replaceCode(text, "/:jump");
        text = replaceCode(text, "/:shake");
        text = replaceCode(text, "/:<O>");

        text = replaceCode(text, "/:circle");
        text = replaceCode(text, "\uD83D\uDE04");
        text = replaceCode(text, "\uD83D\uDE37");
        text = replaceCode(text, "\uD83D\uDE02");
        text = replaceCode(text, "\uD83D\uDE1D");
        text = replaceCode(text, "\uD83D\uDE33");
        text = replaceCode(text, "\uD83D\uDE31");
        text = replaceCode(text, "\uD83D\uDE14");

        text = replaceCode(text, "\uD83D\uDE12");
        text = replaceCode(text, "[Hey]");
        text = replaceCode(text, "[Facepalm]");
        text = replaceCode(text, "[Smirk]");
        text = replaceCode(text, "[Smart]");
        text = replaceCode(text, "[Concerned]");
        text = replaceCode(text, "[Yeah!]");

        text = replaceCode(text, "\uD83D\uDC7B");
        text = replaceCode(text, "\uD83D\uDE4F");
        text = replaceCode(text, "\uD83D\uDCAA");
        text = replaceCode(text, "\uD83C\uDF89");
        text = replaceCode(text, "\uD83C\uDF81");
        text = replaceCode(text, "[Packet]");
        text = replaceCode(text, "[發]");
        text = replaceCode(text, "[小狗]");
        return text;
    }

    private static String replaceCode(String text, String code) {
        if (text.contains(code)) {
            return text.replace(code, map.get(code));
        }
        return text;
    }
}
