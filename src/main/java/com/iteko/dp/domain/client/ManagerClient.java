package com.iteko.dp.domain.client;

import com.iteko.dp.domain.dto.ManagerDTO;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.util.List;

@Headers("Cookie: {cookie}")
public interface ManagerClient {

    @RequestLine("PUT /manager/merge")
    @Headers("Content-Type: application/json")
    ManagerDTO merge(/*@Param("cookie") String cookie,*/
                     ManagerDTO managerDTO);

    @RequestLine("PUT /manager/find/{id}")
    @Headers("Content-Type: application/json")
    ManagerDTO findById(@Param("cookie") String cookie,
                       @Param("id") String id);

    @RequestLine("PUT /manager/remove/{id}")
    @Headers("Content-Type: application/json")
    ManagerDTO removeById(@Param("cookie") String cookie,
                         @Param("id") String id);

    @RequestLine("GET /manager/findAll")
    List<ManagerDTO> findAll(@Param("cookie") String cookie);

    @RequestLine("GET /manager/removeAll")
    void removeAll(@Param("cookie") String cookie);
}
