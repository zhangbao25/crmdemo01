package com.shsxt.crmdemo01.exception;

public class ParamsException extends Exception{
    private Integer code;
    private String msg;


    public ParamsException() {
    }

    public ParamsException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
