package com.demo.springboot2demo02.controller;

import com.demo.springboot2demo02.bean.User;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class TestParamController {

    @ResponseBody
    @PostMapping("/car")
    public User getCar(@RequestBody User user) {
        return user;
    }

    @GetMapping("/goto")
    public String testAttribute(HttpServletRequest request){
        request.setAttribute("name", "zj");
        request.setAttribute("pet", "五月");
        return "forward:/success";
    }

    @ResponseBody
    @GetMapping("/success")
    public Map<String, Object> success(HttpServletRequest request,
                                       @RequestAttribute("name") String aname){
        Map<String, Object> map = new HashMap<>();
        Object username = request.getAttribute("name");
        Object petname = request.getAttribute("pet");
        map.put("username", username);
        map.put("petname", petname);
        map.put("aname", aname);
        return map;
    }
}
