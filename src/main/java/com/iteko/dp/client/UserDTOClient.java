package com.iteko.dp.client;

import com.iteko.dp.dto.UserDTO;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.util.List;

public interface UserDTOClient {

    @RequestLine("GET /{id}")
    UserDTO findById(@Param("id") String id);

    @RequestLine("GET")
    List<UserDTO> findAll();

    @RequestLine("POST")
    @Headers("Content-Type: application/json")
    void create(UserDTO userDTO);

}
