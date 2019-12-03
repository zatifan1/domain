package com.iteco.dp.domain.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

@Component
public class CookieInterceptor implements RequestInterceptor {
    public static String cookie = "";

    @Override
    public void apply(RequestTemplate requestTemplate) {
        System.out.println("Into interceptor");
        requestTemplate.header("Cookie", cookie);
    }
}

