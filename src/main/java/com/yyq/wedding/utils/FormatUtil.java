package com.yyq.wedding.utils;

/**
 * 提供各种转换的工具类
 *
 * @author: 布里巴
 * @review:
 * @date: 2018/12/29
 */
public class FormatUtil {
    /**
     * String[]转int[]
     * @param arrs
     * @return
     */
    public static int[] StringToInt(String[] arrs) {
        int[] ints = new int[arrs.length];
        for (int i = 0;
             i < arrs.length; i++) {
            ints[i] = Integer.parseInt(arrs[i]);
        }
        return ints;
    }

}
