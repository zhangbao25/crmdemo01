package com.shsxt.crmdemo01.exception;

public class NoCookieException extends Exception{
    private Integer code;
    private String msg;

    public NoCookieException() {
    }

    public NoCookieException(Integer code, String msg) {
        this.msg = msg;
    }



    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
