package com.shsxt.crmdemo01.exception;

public class MyException extends Exception {
    private Integer code;
    private String msg;

    public MyException() {
    }

    public MyException(Integer code, String msg) {
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
