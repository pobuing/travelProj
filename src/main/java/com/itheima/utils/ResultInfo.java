package com.itheima.utils;

public class ResultInfo {

    //结果状态码:0 表示成功 其它为失败
    private int code;
    //结果信息
    private String message;
    //数据
    private Object data;

    public ResultInfo(int code) {
        this.code = code;
    }

    public ResultInfo(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResultInfo(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
