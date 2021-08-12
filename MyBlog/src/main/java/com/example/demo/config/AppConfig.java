package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer {


    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.addPathPrefix("api",c -> true);//给所有的Controller加上前缀api
    }

    //配置拦截规则
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**")//拦截所有接口
                .excludePathPatterns("/api/user/login")//不拦截登陆接口
                .excludePathPatterns("/api/user/reg")//不拦截注册接口
                .excludePathPatterns("/login.html")//不拦截登陆页面
                .excludePathPatterns("/regin.html")//不拦截注册页面
                .excludePathPatterns("/**/**.html")
                .excludePathPatterns("/reg_success.html")
                .excludePathPatterns("/reg_error.html")
                .excludePathPatterns("/**/*.css")
                .excludePathPatterns("/**/*.js")
                .excludePathPatterns("/**/*.jpg")
                .excludePathPatterns("/**/*.png");
    }

}