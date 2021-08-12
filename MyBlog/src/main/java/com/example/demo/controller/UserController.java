package com.example.demo.controller;
import com.example.demo.config.AppFinal;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.ArticleInfo;
import com.example.demo.model.User;
import com.example.demo.tools.HtmlText;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@RequestMapping("/user")
@Controller
@Slf4j
public class UserController {

    @Resource
    private UserMapper userMapper;

    @Value("${myimgpath}")
    private String imgPath;

    //声明创建一个当前类的日志对象
    //private Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping("/getalist")
    @ResponseBody
    public Object getFullUser(int uid) {
        User user = userMapper.getFullUser(uid);
        List<ArticleInfo> list = user.getAlist();
        for (ArticleInfo item:list) {
            //去除html标签
            String desc = HtmlText.Html2Text(item.getContent());
            if (desc.length()>64) {
                desc = desc.substring(0, 64) + "......";
            }
            item.setContent(desc);
        }
        user.setAlist(list);
        return user;
    }

    @RequestMapping("/sayhi")
    @ResponseBody
    public String getIndex(String name) {
        if (name == null || name.equals("")) {
            log.error("我的日志信息，级别：error");
        }
        log.debug("我的日志信息，级别：debug");
        log.warn("我的日志信息，级别：warn");
        log.info("我的日志信息，级别：info");
        log.trace("我的日志信息，级别：trace");
        return "Hello，SpringBoot";
    }

    @RequestMapping("/login")
    @ResponseBody
    public Object login(User user, HttpServletRequest request) throws JsonProcessingException {

        User user2 = userMapper.getUserByNameAndPassword(user.getUsername(),user.getPassword());
        if (user2 ==null) {
            user2 = user;
        }else {
            //登陆成功，设置session
            HttpSession session = request.getSession();
            //存放到session中
            session.setAttribute(AppFinal.USERINFO_SESSIONKEY,user2);
        }
        return user2;


        //返回的对象

       /* HashMap<String,Object> map = new HashMap();
        int status = -1; //非正常返回
        String msg = "未知错误";
        String data = "登陆失败";
        if (user!=null && user.getUsername().equals("root") && user.getPassword().equalsIgnoreCase("root")) {
            //登录信息存储到session
            HttpSession session = request.getSession();
            session.setAttribute(AppFinal.USERINFO_SESSIONKEY, user);
            status = 0;
            msg = "";
            data = "登陆成功";
        }else {
            status = 0;
            msg = "用户名错误";
            data = "登陆失败";
        }
        map.put("status",status);
        map.put("msg",msg);
        map.put("data",data);
        return map;*/
    }



    @RequestMapping("/reg")
    public String regin(String username,String password,
                        @RequestPart MultipartFile file) throws IOException {



        //1.动态获取当前项目路径
        //String path = ClassUtils.getDefaultClassLoader().getResource("static").getPath();
        String path = imgPath;
        path += AppFinal.IMAGE_PATH;
        log.info("path:" + path);
        //2.文件名（全局唯一id-uuid）+ 文件的原始类型
        String fileType = file.getOriginalFilename(); //img.png
        fileType = fileType.substring(fileType.lastIndexOf("."));//拿到点后的信息
        //文件名
        String filename = UUID.randomUUID().toString()+fileType;

        //将文件保存到当前服务器
        file.transferTo(new File(path+filename));
        //将用户信息存储到服务器
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        //设置头像地址
        user.setPhoto(AppFinal.IMAGE_PATH + filename);
        int result = userMapper.addUser(user);
        if (result > 0) {
            //表示操作成功
            return "redirect:/reg_success.html";
        }else {
            return "redirect:/reg_error.html";
        }
    }

    @Transactional
    public void methodAll(){
        methodA();
        methodB();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void methodB() {
    }
    @Transactional(propagation = Propagation.REQUIRED)
    public void methodA() {
    }

}
