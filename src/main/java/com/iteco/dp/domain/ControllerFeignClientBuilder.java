package com.iteco.dp.domain;

import com.iteco.dp.domain.client.AuthClient;
import com.iteco.dp.domain.client.CandidateClient;
import com.iteco.dp.domain.client.ManagerClient;
import com.iteco.dp.domain.client.UserClient;
import com.iteco.dp.domain.interceptor.CookieInterceptor;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import lombok.Getter;

@Getter
public class ControllerFeignClientBuilder {

    private UserClient userClient = createClient(UserClient.class, "http://localhost:8080/api/user");
    private AuthClient authClient = createClient(AuthClient.class, "http://localhost:8080/api");
    private CandidateClient candidateClient = createClient(CandidateClient.class, "http://localhost:8080/api/");
    private ManagerClient managerClient = createClient(ManagerClient.class, "http://localhost:8080/api/");

    private static <T> T createClient(Class<T> type, String uri) {
        return Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(type))
                .logLevel(Logger.Level.FULL)
                .requestInterceptor(new CookieInterceptor())
                .target(type, uri);
    }

}
