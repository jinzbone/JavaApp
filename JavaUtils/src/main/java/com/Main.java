package com;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static List<String> res = new ArrayList<>();
    public static void main(String[] args) {
        String s = "[{\"code\":\"JI65DBVYMK\",\"children\":[{\"code\":\"userapply\",\"children\":[],\"orderSize\":0,\"name\":\"我的申请\",\"pid\":\"JI7534HOX7\",\"id\":\"JIKL07LXTV\",\"type\":\"M\",\"url\":\"http://10.0.0.57:8080/#/userapply\"},{\"code\":\"userverify\",\"children\":[],\"orderSize\":0,\"name\":\"我的审核\",\"pid\":\"JI7534HOX7\",\"id\":\"JIL8MFJBWP\",\"type\":\"M\",\"url\":\"http://10.0.0.57:8080/#/userexamine\"},{\"code\":\"userauth\",\"children\":[],\"orderSize\":0,\"name\":\"权限管理\",\"pid\":\"JI7534HOX7\",\"id\":\"JILN9O2HG5\",\"type\":\"M\",\"url\":\"http://10.0.0.57:8080/#/limitmanage\"},{\"code\":\"tbauth\",\"children\":[],\"orderSize\":0,\"name\":\"我的权限\",\"pid\":\"JI7534HOX7\",\"id\":\"JIM5RR86QF\",\"type\":\"M\",\"url\":\"http://10.0.0.57:8080/#/userlimit\"},{\"code\":\"usersystem\",\"children\":[],\"orderSize\":0,\"name\":\"用户设置\",\"pid\":\"JI7534HOX7\",\"id\":\"JIMJLPC3O1\",\"type\":\"M\",\"url\":\"http://10.0.0.57:8080/#/usersystem\"},{\"code\":\"wacatalog\",\"children\":[],\"orderSize\":0,\"name\":\"网络安全数据资源目录\",\"pid\":\"JI7534HOX7\",\"id\":\"KVQP4ID6V1\",\"type\":\"M\",\"url\":\"http://10.0.0.57:8080/#/datacata\"}],\"orderSize\":0,\"name\":\"数据资源目录\",\"pid\":\"0\",\"id\":\"JI7534HOX7\",\"type\":\"APP\",\"url\":\"http://10.0.0.31:8080/#/datacata\"}]";
        JSONArray arr = new JSONArray();
        arr = JSONArray.fromObject(s);
        Iterator it = arr.iterator();
        System.out.println(res);
        decodeJ(it);
        System.out.println(res);
    }
    public  static void decodeJ(Iterator it){
        while (it.hasNext()){
            JSONObject obj = (JSONObject) it.next();
            if (obj.has("children")){
                JSONArray jsonArray = (JSONArray) obj.get("children");
                Iterator cit = jsonArray.iterator();
                decodeJ(cit);
                res.add(obj.getString("code"));
                System.out.println(obj);
            }
        }
    }
}
