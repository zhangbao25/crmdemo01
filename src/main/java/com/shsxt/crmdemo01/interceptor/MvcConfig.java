package com.shsxt.crmdemo01.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Bean
    public MyInterceptor myInterceptor(){
        return new MyInterceptor();
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(myInterceptor());

        interceptorRegistration.addPathPatterns("/**");
        interceptorRegistration.excludePathPatterns("/index","/user/login","/js/**","/css/**","/images/**","/lib/**");
    }
}
