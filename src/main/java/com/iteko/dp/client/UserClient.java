package com.iteko.dp.client;

import com.iteko.dp.dto.UserDTO;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.util.List;

@Headers("Cookie: {cookie}")
public interface UserClient {

    @RequestLine("PUT /merge")
    @Headers("Content-Type: application/json")
    void merge(@Param("cookie") String cookie, UserDTO userDTO);

    @RequestLine("GET /find/{id}")
    UserDTO findById(@Param("cookie") String cookie, @Param("id") String id);

    @RequestLine("DELETE /remove/{id}")
    @Headers("Content-Type: application/json")
    void remove(@Param("cookie") String cookie, @Param("id") String id);

    @RequestLine("GET /findAll")
    List<UserDTO> findAll(@Param("cookie") String cookie);

    @RequestLine("PUT /mergeAll")
    @Headers("Content-Type: application/json")
    void mergeAll(@Param("cookie") String cookie, List<UserDTO> userDTOList);

    @RequestLine("DELETE /removeAll")
    void removeAll(@Param("cookie") String cookie);

}
