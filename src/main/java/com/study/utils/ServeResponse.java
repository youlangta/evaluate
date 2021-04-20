package com.study.utils;

public class ServeResponse<T> {

    private String returnCode;

    private String returnMsg;

    private T data;

    public ServeResponse() {

    }

    public ServeResponse(String returnCode, String returnMsg, T data) {
        this.returnCode = returnCode;
        this.returnMsg = returnMsg;
        this.data = data;
    }

    public static ServeResponse response(Object o) {
        return new ServeResponse("000000", "", o);
    }

    public static ServeResponse error(String msg) {
        return new ServeResponse("000001", msg, null);
    }

    public static ServeResponse errorResponse(String returnCode, String msg) {
        return new ServeResponse(returnCode, msg, null);
    }

    public static ServeResponse success() {
        return new ServeResponse("000000", "", null);
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
