package com.yyq.wedding.exception;

import com.yyq.wedding.domain.enums.ExceptionEnum;
import lombok.Data;

import java.text.MessageFormat;

/**
 * @author: 布里巴
 * @review:
 * @date: 2018/12/28
 */
@Data
public class WeddingException extends RuntimeException {
    private Integer code;
    private String msg;

    public WeddingException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static WeddingException build(Integer code, String msg) {
        return new WeddingException(code, msg);
    }

    public static WeddingException build(ExceptionEnum exceptionEnum) {
        return new WeddingException(exceptionEnum.code, exceptionEnum.msg);
    }

    public static WeddingException build(ExceptionEnum exceptionEnum, Object... strings) {
        return new WeddingException(exceptionEnum.code, MessageFormat.format(exceptionEnum.msg, strings));
    }
}
