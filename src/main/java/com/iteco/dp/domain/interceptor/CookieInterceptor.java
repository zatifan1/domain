package com.iteco.dp.domain.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class CookieInterceptor implements RequestInterceptor {
    private static final String COOKIE = "Accept-Language";

    @Override
    public void apply(RequestTemplate requestTemplate) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (requestAttributes == null) {
            return;
        }
        HttpServletRequest request = requestAttributes.getRequest();
        if (request == null) {
            return;
        }
        String cookie = request.getHeader("Set-cookie");
        if (cookie == null) {
            return;
        }
        requestTemplate.header(COOKIE, cookie);
    }
}

