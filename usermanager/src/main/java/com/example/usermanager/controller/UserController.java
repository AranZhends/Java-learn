package com.example.usermanager.controller;

import com.example.usermanager.mapper.UserMapper;
import com.example.usermanager.model.UserInfo;
import com.example.usermanager.tools.AppFinal;
import com.example.usermanager.tools.ResponseBody;
import com.example.usermanager.tools.SessionUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserMapper userMapper;

    //登陆方法
    @RequestMapping("/login")
    public ResponseBody<UserInfo> login(@RequestParam String username, @RequestParam String password,HttpServletRequest request) {
        UserInfo userInfo = userMapper.login(username,password);
        int status = -1;
        String message = "用户或密码错误!";
        if (userInfo!=null && userInfo.getId()>0) {
            status = 0;
            message = "";
            //将用户对象存入session
            HttpSession session = request.getSession();
            session.setAttribute(AppFinal.USERINFO_SESSION_KEY,userInfo);
        }
        return new ResponseBody<>(status,message,userInfo);
    }

    @RequestMapping("/checkadmin")
    public ResponseBody<Integer> checkAdmin(HttpServletRequest request){
        int data = 0;
        UserInfo userInfo = null;
        HttpSession session = request.getSession(false);
        if (session!=null && (userInfo = (UserInfo)session.getAttribute(AppFinal.USERINFO_SESSION_KEY))!=null) {
            data = userInfo.getIsadmin();
        }
        return new ResponseBody<>(0,"",data);
    }

    //添加用户方法
    @RequestMapping("/add")
    public ResponseBody<Integer> add(UserInfo userInfo,HttpServletRequest request){
        int status = 0;
        int data = 0;
        String message = "";
        //安全校验
        UserInfo user = SessionUtil.getUserBySession(request);
        if (user == null) {
            status = -1;
            message = "当前用户未登录，请先登录!";
        }else if (userInfo.getIsadmin()==1){

            if (user!=null && user.getIsadmin()==1) {
                //当前用户登录为超级管理员
                data = userMapper.add(userInfo);
            }else if (user!=null && user.getIsadmin()==0) {
                status = -2;
                message = "当前登录用户权限不足,不能操作";
            }
        }else if (userInfo.getIsadmin()==0){
            //添加普通管理员
            data = userMapper.add(userInfo);
        }
        return new ResponseBody<>(status,message,data);
    }

    @RequestMapping("/getuser")
    public ResponseBody<UserInfo> getUser(@RequestParam int uid){
        int status = -1;
        String message="未知错误";
        UserInfo userInfo = userMapper.getUser(uid);
        if (userInfo!=null){
            //todo:权限校验
            status=0;
        }
        return new ResponseBody<>(status,message,userInfo);
    }

    @RequestMapping("/update")
    public ResponseBody<Integer> update(UserInfo userInfo){
        int data = 0;
        //todo:权限校验
        data = userMapper.update(userInfo);
        return new ResponseBody<>(0,"",data);
    }

    @RequestMapping("/list")
    public ResponseBody<HashMap<String, Object>> getList(String name,
                                                         String address,
                                                         String email,
                                                         int cpage,
                                                         int psize,
                                                         HttpServletRequest request
    ) {
        // 1.权限效验
        UserInfo userInfo = SessionUtil.getUserBySession(request);
        if (userInfo == null) {
            // 未登录
            return new ResponseBody<>(-1, "当前用户未登录", null);
        }
        // 2.判断权限
        Integer isadmin = null;
        if (userInfo.getIsadmin() == 0) {
            isadmin = 0;
        }
        // 处理前端的查询参数
        name = name.equals("") ? null : name;
        address = address.equals("") ? null : address;
        email = email.equals("") ? null : email;
        // 3.构建分页查询字段 limit xx,psize 查询当前页面的列表信息
        // 跳过查询的条数
        int skipCount = (cpage - 1) * psize;
        // 查询一页的列表信息
        List<UserInfo> list = userMapper.getListByPage(name, address, email,
                skipCount, psize, isadmin);
        // 4.查询满足条件的数据总条数
        int tcount = userMapper.getCount(name, address, email, isadmin);
        // 总页数
        int tpage = (int) Math.ceil(tcount / (psize * 1.0));
        // 封装统一返回对象
        HashMap<String, Object> data = new HashMap<>();
        data.put("list", list);
        data.put("tcount", tcount); // 总条数
        data.put("tpage", tpage);  // 总条数
        return new ResponseBody<>(0, "", data);
    }

    @RequestMapping("/del")
    public ResponseBody<Integer> del(@RequestParam int id, HttpServletRequest request) {
        // 权限效验
        UserInfo userInfo = SessionUtil.getUserBySession(request);
        if (userInfo == null) {
            // 未登录
            return new ResponseBody<>(-1, "未登录", 0);
        }
        // 判断删除的是否是自己
        if (id == userInfo.getId()) {
            // 删除的是自己
            return new ResponseBody<>(-2, "不能删除自己", 0);
        }
        // 权限效验
        Integer isadmin = null;
        if (userInfo.getIsadmin() == 0) {
            isadmin = 0;
        }
        int result = userMapper.del(id, isadmin);
        return new ResponseBody<>(0, "", result);
    }

    // 多条数据删除
    @RequestMapping("dels")
    public ResponseBody<Integer> dels(String ids) {
        int result = 0;
        result = userMapper.dels(ids.split(","));
        System.out.println("ids:" + ids);
        return new ResponseBody<>(0, "", result);
    }
}
