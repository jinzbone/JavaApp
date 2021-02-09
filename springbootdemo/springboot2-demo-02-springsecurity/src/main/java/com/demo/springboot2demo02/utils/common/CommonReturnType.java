package com.demo.springboot2demo02.utils.common;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class CommonReturnType implements Serializable {
    private String msg;
    private boolean res;
    private Object data;

    public void CommonReturnType(String msg, boolean res, Object object){
        this.msg = msg;
        this.res = res;
        this.data = object.toString();
    }
    public static CommonReturnType ok(){
        CommonReturnType commonReturnType = new CommonReturnType();
        commonReturnType.setMsg("成功");
        commonReturnType.setRes(true);
        return commonReturnType;
    }
    public static CommonReturnType ok(Object object){
        CommonReturnType commonReturnType = new CommonReturnType();
        commonReturnType.setMsg("成功");
        commonReturnType.setRes(true);
        commonReturnType.setData(object);
        return commonReturnType;
    }
    public static CommonReturnType error(){
        CommonReturnType commonReturnType = new CommonReturnType();
        commonReturnType.setMsg("失败");
        commonReturnType.setRes(false);
        return commonReturnType;
    }
    public static CommonReturnType error(Object object){
        CommonReturnType commonReturnType = new CommonReturnType();
        commonReturnType.setMsg("失败");
        commonReturnType.setRes(true);
        commonReturnType.setData(object);
        return commonReturnType;
    }
}
