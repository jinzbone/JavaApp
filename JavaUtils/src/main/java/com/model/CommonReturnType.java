package com.model;

import net.sf.json.JSONObject;

/**
 * @Description: 前后传参常用的返回数据的格式
 * @Author: zhangjing
 * @Date: 2021/3/2 9:56
*/
public class CommonReturnType {

    private boolean status;
    private String message;
    private Object data;

    private static JSONObject newJson = new JSONObject();

    public CommonReturnType(boolean status, String message, Object data) {
        super();
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public CommonReturnType() {}


    public static CommonReturnType ok(Object data, String message) {
        return new CommonReturnType(true, message, data);
    }

    public static CommonReturnType ok(String message) {
        return new CommonReturnType(true, message, newJson);
    }

    public static CommonReturnType error(String message) {
        return new CommonReturnType(false, message, newJson);
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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
