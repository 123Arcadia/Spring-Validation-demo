package com.zcw.springvalidationdemo.ResultHandle;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;


@Data
@Accessors(chain = true)
public class Result<T> implements Serializable {

    private static final long serialVersionUID = -504027247149928390L;

    private int code;
    private String msg;
    private String exceptionMsg;
    private T body;

    public static <T> Result ok(T body) {
        return new Result<>()
                .setBody(body)
                .setCode(ResultCode.SUCCESS.getCode())
                .setMsg(ResultCode.SUCCESS.getMsg());
    }

    public static Result ok() {
        return new Result<>()
                .setCode(ResultCode.SUCCESS.getCode())
                .setMsg(ResultCode.SUCCESS.getMsg());
    }

    public static Result defaultFail(ResultCode resultCode) {
        return new Result<>()
                .setCode(ResultCode.FAIL.getCode())
                .setMsg(ResultCode.FAIL.getMsg());
    }

    public static Result fail(ResultCode resultCode, String errorMag) {
        return new Result<>()
                .setCode(ResultCode.FAIL.getCode())
                .setMsg(ResultCode.FAIL.getMsg())
                .setExceptionMsg(errorMag);
    }
}
