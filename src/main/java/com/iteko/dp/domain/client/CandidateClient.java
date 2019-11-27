package com.iteko.dp.domain.client;

import com.iteko.dp.domain.dto.CandidateDTO;
import com.iteko.dp.domain.dto.InterviewDTO;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.util.List;

@Headers("Cookie: {cookie}")
public interface CandidateClient {

    @RequestLine("PUT /candidate/merge")
    @Headers("Content-Type: application/json")
    CandidateDTO merge(@Param("cookie") String cookie, CandidateDTO candidateDTO);

    @RequestLine("PUT /candidate/find/{id}")
    @Headers("Content-Type: application/json")
    CandidateDTO findById(@Param("cookie") String cookie, @Param("id") String id);

    @RequestLine("PUT /candidate/remove/{id}")
    @Headers("Content-Type: application/json")
    CandidateDTO removeById(@Param("cookie") String cookie, @Param("id") String id);

    @RequestLine("GET /canditate/findAll")
    List<CandidateDTO> findAll(@Param("cookie") String cookie);

    @RequestLine("GET /candidate/interviews")
    InterviewDTO interviews(@Param("cookie") String cookie);

    @RequestLine("GET /candidate/register")
    @Headers({"Login: {login}", "Password: {password}"})
    CandidateDTO register(@Param("cookie") String cookie,
                       @Param("login") String login,
                       @Param("password") String password);

    @RequestLine("GET /candidate/removeAll")
    void removeAll(@Param("cookie") String cookie);
}