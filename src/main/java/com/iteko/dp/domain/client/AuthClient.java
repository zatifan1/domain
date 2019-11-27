package com.iteko.dp.domain.client;

import com.iteko.dp.domain.dto.PersonDTO;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import feign.Response;

@Headers("Cookie: {cookie}")
public interface AuthClient {

    @RequestLine("POST /auth")
    @Headers({"Login: {login}", "Password: {password}"})
    Response auth(@Param("login") String login,
                  @Param("password") String password);

    @RequestLine("POST /auth")
    Response auth1();

    @RequestLine("GET /logout")
    @Headers("userId: {id}")
    void logout(@Param("cookie") String cookie,
                @Param("id") String id);

    @RequestLine("GET /profile")
    @Headers("userId: {id}")
    void profile(@Param("cookie") String cookie,
                 @Param("id") String id);

    @RequestLine("PUT /profile/merge")
    @Headers({"Content-type: application/json", "userId: {id}"})
    void profileMerge(@Param("cookie") String cookie,
                      @Param("id") String id,
                      PersonDTO person);

}
