package com.springboot.interceptors;

import com.springboot.model.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IsLoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user= (User) request.getSession().getAttribute("userSession");
        if(user==null){
            response.getWriter().println("<script> window.top.location.href='/toLogin' </script>");
            return false;
        }
        return true;
    }
}
