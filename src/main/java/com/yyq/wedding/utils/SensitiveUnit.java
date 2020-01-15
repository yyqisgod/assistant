package com.yyq.wedding.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.Set;
import java.util.TreeSet;

/**
 * 敏感词过滤器，以过滤速度优化为主。<br/>
 * * 获取默认的单例：{@link #DEFAULT}
 *
 * @author ZhangXiaoye
 * @date 2017年1月5日 下午4:18:38
 */
@Slf4j
public class SensitiveUnit implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 敏感词库
     */
    private static Set<String> sensitiveWord = new TreeSet<>();

    /**
     * 默认的单例，使用自带的敏感词库
     */
    private static SensitiveUnit DEFAULT;

    static {
        try {
            DEFAULT = new SensitiveUnit(new BufferedReader(new InputStreamReader(new ClassPathResource("template/sensi_words.txt").getInputStream(), StandardCharsets.UTF_8)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private SensitiveUnit() {

    }

    /**
     * 读取默认的敏感词词库
     */
    private SensitiveUnit(BufferedReader reader) {
        try {
            for (String line = reader.readLine(); !StringUtils.isEmpty(line); line = reader.readLine()) {
                sensitiveWord.add(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 替换敏感词
     */
    public static String replace(String work, String replaceWork) {
        for (String s : sensitiveWord) {
            work = work.replace(s, replaceWork);
        }
        return work;
    }

    /**
     * 判断是否包含敏感字符
     */
    public static boolean isSensitive(String work) {
        for (String s : sensitiveWord) {
            boolean contains = work.contains(s);
            if (contains) {
                return true;
            }
        }
        return false;
    }
}
