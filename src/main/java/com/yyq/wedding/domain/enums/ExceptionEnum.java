package com.yyq.wedding.domain.enums;

/**
 * @author: 布里巴
 * @review:
 * @date: 2018/12/28
 */
public enum  ExceptionEnum {

    DONT_SEND_IMG(500,"不能发送图片");

    public Integer code;
    public String msg;

    private ExceptionEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static String getMsg(Integer code) {
        ExceptionEnum[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            ExceptionEnum resultEnum = var1[var3];
            if (resultEnum.code.compareTo(code) == 0) {
                return resultEnum.msg;
            }
        }

        return null;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }
}
