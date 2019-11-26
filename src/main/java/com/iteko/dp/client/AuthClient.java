package com.iteko.dp.client;

import com.iteko.dp.entity.Person;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import feign.Response;

@Headers("Cookie: {cookie}")
public interface AuthClient {

    @RequestLine("POST /auth")
    @Headers({"Login: {login}", "Password: {password}"})
    Response auth(@Param("cookie") String cookie,
                  @Param("login") String login,
                  @Param("password") String password);

    @RequestLine("GET /logout")
    @Headers("userId: {id}")
    void logout(@Param("cookie") String cookie,
                @Param("id") String id);

    @RequestLine("GET /profile")
    @Headers("userId: {id}")
    void profile(@Param("cookie") String cookie,
                 @Param("id") String id);

    @RequestLine("PUT /profile/merge")
    @Headers({"Content-type: application/json","userId: {id}"})
    void profileMerge(@Param("cookie") String cookie,
                      @Param("id") String id,
                      Person person);

}
