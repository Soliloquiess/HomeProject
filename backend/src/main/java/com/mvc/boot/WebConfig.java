package com.mvc.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.mvc.boot.interceptor.JwtInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {
//	private static final String[] EXCLUDE_PATHS = {
//            "/user/**",
//            "/error/**"
//    };
//
//    @Autowired
//    private JwtInterceptor jwtInterceptor;
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(jwtInterceptor)
//						.addPathPatterns("/**")
//						.excludePathPatterns(EXCLUDE_PATHS);
//    }
}
