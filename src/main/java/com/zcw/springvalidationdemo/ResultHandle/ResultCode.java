package com.zcw.springvalidationdemo.ResultHandle;

/**
 * 返回状态码
 */
public enum ResultCode {

    SUCCESS("成功", 200),
    FAIL("失败", 500),
    EXCEPTION("异常", -1);

    private String msg;
    private int code;
    ResultCode(String msg, int code) {
        this.msg = msg;
        this.code=code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
