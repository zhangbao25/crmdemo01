package com.shsxt.crmdemo01.interceptor;

import com.shsxt.crmdemo01.exception.NoCookieException;
import com.shsxt.crmdemo01.utils.GetCookieFromRequest;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute("ctx", request.getContextPath());
        String id=GetCookieFromRequest.getValueFromCookieByName(request,"id");
        if(id==null||"".equals(id)){
            throw new NoCookieException(400000,"没有cookie");
    }
        return true;
    }
}
