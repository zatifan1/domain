package com.iteco.dp.domain.client;

import com.iteco.dp.domain.dto.UserDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("user")
@RequestMapping(value = "/user")
public interface UserClient {

    @PutMapping(value = "/merge", produces = "application/json", consumes = "application/json")
    void merge(@RequestHeader("Cookie") String cookie,
               @RequestBody UserDTO userDTO);

    @GetMapping(value = "/find/{id}", consumes = "application/json")
    UserDTO findById(@RequestHeader("Cookie") String cookie,
                     @PathVariable("id") String id);

    @DeleteMapping(value = "/remove/{id}")
    void remove(@RequestHeader("Cookie") String cookie,
                @PathVariable("id") String id);

    @GetMapping(value = "/findAll", consumes = "application/json")
    List<UserDTO> findAll(@RequestHeader("Cookie") String cookie);

    @PutMapping(value = "/mergeAll", produces = "application/json")
    void mergeAll(@RequestHeader("Cookie") String cookie,
                  List<UserDTO> userDTOList);

    @DeleteMapping(value = "/removeAll")
    void removeAll(@RequestHeader("Cookie") String cookie);
}
