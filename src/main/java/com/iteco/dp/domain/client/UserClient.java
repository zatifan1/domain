package com.iteco.dp.domain.client;

import com.iteco.dp.domain.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("user")
@RequestMapping(value = "/user")
public interface UserClient {

    @PutMapping(value = "/create", produces = "application/json", consumes = "application/json")
    UserDTO create(@RequestBody UserDTO userDTO);

    @PutMapping(value = "/update", produces = "application/json", consumes = "application/json")
    UserDTO update(@RequestBody UserDTO userDTO);

    @GetMapping(value = "/find/{id}", consumes = "application/json")
    UserDTO findById(@PathVariable("id") String id);

    @DeleteMapping(value = "/remove/{id}", consumes = "application/json")
    UserDTO deleteById(@PathVariable("id") String id);

    @GetMapping(value = "/findAll", consumes = "application/json")
    List<UserDTO> findAll();

}
