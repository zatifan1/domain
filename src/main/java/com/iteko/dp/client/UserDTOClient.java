package com.iteko.dp.client;

import com.iteko.dp.dto.UserDTO;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.util.List;

public interface UserDTOClient {

    @RequestLine("PUT /merge")
    @Headers("Content-Type: application/json")
    void merge(UserDTO userDTO);

    @RequestLine("GET /find/{id}")
    UserDTO findById(@Param("id") String id);

    @RequestLine("DELETE /remove/{id}")
    @Headers("Content-Type: application/json")
    void remove(@Param("id") String id);

    @RequestLine("GET /findAll")
    @Headers("Cookie: {cookie}")
    List<UserDTO> findAll(@Param("cookie") String cookie);

    @RequestLine("PUT /mergeAll")
    @Headers("Content-Type: application/json")
    void mergeAll(List<UserDTO> userDTOList);

    @RequestLine("DELETE /removeAll")
    void removeAll();

}
