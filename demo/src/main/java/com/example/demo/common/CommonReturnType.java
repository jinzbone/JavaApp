package com.example.demo.common;

import net.sf.json.JSONObject;

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

