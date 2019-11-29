package com.iteco.dp.domain.client;

import com.iteco.dp.domain.dto.PersonDTO;
import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("auth")
public interface AuthClient {

    @PostMapping(value = "/auth")
    Response auth(@RequestHeader("login") String login,
                  @RequestHeader("password") String password);

    @GetMapping(value = "/logout")
    void logout(@RequestHeader("Cookie") String cookie);

    @GetMapping(value = "/profile")
    PersonDTO profile(@RequestHeader("Cookie") String cookie);

    @PutMapping(value = "/profile", produces = "application/json")
    void profileMerge(@RequestHeader("Cookie") String cookie, @RequestBody PersonDTO person);

}
