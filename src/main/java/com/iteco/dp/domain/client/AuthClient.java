package com.iteco.dp.domain.client;

import com.iteco.dp.domain.dto.PersonDTO;
import feign.Response;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("auth")
public interface AuthClient {

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    Response auth(@RequestHeader("login") String login,
                  @RequestHeader("password") String password);

    @GetMapping(value = "/logout")
    void logout(@RequestHeader("Cookie") String cookie);

    @GetMapping(value = "/profile")
    PersonDTO profile(@RequestHeader("Cookie") String cookie);

    @PutMapping(value = "/profile/merge", produces = "application/json")
    void profileMerge(@RequestHeader("Cookie") String cookie, @RequestBody PersonDTO person);

}
