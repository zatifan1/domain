package com.iteko.dp.client;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import feign.Response;

public interface AuthDTOClient {

    @RequestLine("POST /auth")
    @Headers({"Login: {login}", "Password: {password}"})
    Response auth(@Param("login") String login,
                  @Param("password") String password);

}
