package com.iteco.dp.domain;


import com.iteco.dp.domain.client.AuthClient;
import com.iteco.dp.domain.client.ManagerClient;
import com.iteco.dp.domain.client.UserClient;
import com.iteco.dp.domain.interceptor.CookieInterceptor;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.cloud.openfeign.support.SpringMvcContract;

public class AuthResourceClient {

    public static AuthClient getAuthInstance(final String baseUrl) {
        return Feign.builder()
                .contract(new SpringMvcContract())
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .requestInterceptor(new CookieInterceptor())
                .target(AuthClient.class, baseUrl);
    }

    public static ManagerClient getManagerInstance(final String baseUrl) {
        return Feign.builder()
                .contract(new SpringMvcContract())
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(ManagerClient.class, baseUrl);
    }

    public static UserClient getUserInstance(final String baseUrl) {
        return Feign.builder()
                .contract(new SpringMvcContract())
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(UserClient.class, baseUrl);
    }
}

