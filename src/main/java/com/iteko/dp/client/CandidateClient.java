package com.iteko.dp.client;

import com.iteko.dp.dto.UserDTO;
import com.iteko.dp.entity.Candidate;
import com.iteko.dp.entity.Interview;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.util.List;

@Headers("Cookie: {cookie}")
public interface CandidateClient {

    @RequestLine("PUT /candidate/merge")
    @Headers("Content-Type: application/json")
    Candidate merge(@Param("cookie") String cookie,
               UserDTO userDTO);

    @RequestLine("PUT /candidate/find/{id}")
    @Headers("Content-Type: application/json")
    Candidate findById(@Param("cookie") String cookie,
                       @Param("id") String id);

    @RequestLine("PUT /candidate/remove/{id}")
    @Headers("Content-Type: application/json")
    Candidate removeById(@Param("cookie") String cookie,
                       @Param("id") String id);

    @RequestLine("GET /canditate/findAll")
    List<Candidate> findAll(@Param("cookie") String cookie);

    @RequestLine("GET /candidate/interviews")
    Interview interviews(@Param("cookie") String cookie);

    @RequestLine("GET /candidate/register")
    @Headers({"Login: {login}", "Password: {password}"})
    Candidate register(@Param("cookie") String cookie,
                       @Param("login") String login,
                       @Param("password") String password);

    @RequestLine("GET /candidate/removeAll")
    void removeAll(@Param("cookie") String cookie);



}