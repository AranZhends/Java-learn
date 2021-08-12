package com.example.demo.controller;

import com.example.demo.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
//相当于@Controller + @ResponseBody （返回后端数据而非视图）
@RequestMapping("/mvc")
@Slf4j
public class MVCController {
    @Autowired
    private ObjectMapper objectMapper;

    @RequestMapping("/index5")
    public User getIndex5() throws JsonProcessingException {
        User user = new User();
        user.setUsername("Java");
        user.setPassword("hello");

        return user;
    }

    @RequestMapping("/index4")
    public String getIndex4() throws JsonProcessingException {
        User user = new User();
        user.setUsername("Java");
        user.setPassword("hello");

        //将对象转化为jason字符串
        String result = objectMapper.writeValueAsString(user);
        log.error(result);

        return result;
    }

    @RequestMapping("/index")
    public String getIndex() {
      log.error("我是index.html");
        return "redirect:/index.html";
    }
    @RequestMapping("/index2")
    public String getIndex2() {
        log.error("我是请求转发");
        return "forward:/index.html";
    }
    @RequestMapping("/index3")
    public String getIndex3(HttpServletResponse response) {
        response.setStatus(301);
        response.setHeader("Location","/index.html");
        return null;
    }
}
