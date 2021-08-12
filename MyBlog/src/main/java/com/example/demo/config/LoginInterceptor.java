package com.example.demo.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        
    }

    //自定义拦截方法：返回true表示可以访问后端接口，返回false表示所有接口都拦截掉
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //todo:上线恢复session校验
        //判断session内是否有值
        HttpSession session = request.getSession(false);
        if (session!=null &&session.getAttribute(AppFinal.USERINFO_SESSIONKEY)!=null) {
            //用户已经登陆
            return true;
        }
        return false;


    }

}
