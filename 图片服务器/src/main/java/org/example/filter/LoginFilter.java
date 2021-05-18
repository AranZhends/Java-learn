package org.example.filter;

import org.example.util.Util;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/*
用户会话的统一管理：基于过滤器的实现
可以统一的进行权限管理，过滤敏感信息等等
 */
//匹配所有路径，所有路径都要进行校验
@WebFilter("/*")
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest)servletRequest;
        HttpServletResponse resp = (HttpServletResponse)servletResponse;
        //获取请求路，判断是否为敏感资源，如果是，就要校验Session
        String uri = req.getServletPath();//应用上下文路径后边的服务路径
        //前端敏感资源为index.html，后端敏感资源为/image,/imageShow
        if (uri.equals("/index.html") && !islogin(req)) {
            //前端敏感资源重定向到登陆页面
            //真实的代码需要写绝对路径（通过request对象获取绝对路径的每个部分）
            //req.getScheme();//http
            //req.getServerName();//ip或域名
            //req.getServerPort();//port
            //req.getServletPath();//应用上下文路径

            resp.sendRedirect("login.html");
            return;
        }else if ((uri.equals("/image") || uri.equals("/imageShow")) && !islogin(req)) {
            //后端敏感资源，设置401响应状态码，返回json数据
            resp.setCharacterEncoding("utf-8");
            resp.setContentType("application/json");
            resp.setStatus(401);
            Map<String,Object> map = new HashMap<>();
            map.put("ok",false);
            map.put("msg","用户未登录，不允许访问");
            String json = Util.serialize(map);
            resp.getWriter().println(json);
            return;
        }
        //前后端是敏感资源但已登录或是开放资源允许访问
        filterChain.doFilter(servletRequest,servletResponse);

    }
    public static boolean islogin(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session!=null) {
            //获取的键为登陆时保存在Session中的键
            Object username = session.getAttribute("username");
            if (username!=null) {
                return true;
            }
        }
        //未登录的用户访问
        return false;
    }

    @Override
    public void destroy() {

    }
}
