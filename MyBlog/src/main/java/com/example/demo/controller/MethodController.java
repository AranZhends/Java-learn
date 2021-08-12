package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/met")
public class MethodController {

    @GetMapping("/people/{pid}/animal/{aid}")
    public String method1(@PathVariable String pid,@PathVariable("aid") String animalId) {
        return "用户id:" + pid +"," + "动物id:" + animalId;
    }

    @RequestMapping("/reg")
    public String method4(@RequestParam String name) {
        return "姓名：" + name;
    };

    @GetMapping("/getname")
    public String method2(String name) {
        return "姓名 :" +name;
    }

    @RequestMapping("/login")
    public String method3(@RequestBody User user, HttpServletRequest request) {
        if (user.getUsername().equals("root") && user.getPassword().equals("root")) {
            //登录信息存储到session
            HttpSession session = request.getSession();
            session.setAttribute("userinfo",user);
            return "登陆成功";
        }
        return "登陆失败";

    }

}
