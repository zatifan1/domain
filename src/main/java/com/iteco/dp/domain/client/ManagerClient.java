package com.iteco.dp.domain.client;

import com.iteco.dp.domain.dto.ManagerDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("manager")
@RequestMapping(value = "/manager")
public interface ManagerClient {

    @PutMapping(value = "/merge", produces = "application/json", consumes = "application/json")
    ManagerDTO merge(@RequestHeader("Cookie") String cookie, @RequestBody ManagerDTO managerDTO);

    @GetMapping(value = "/find/{id}", consumes = "application/json")
    ManagerDTO findById(@RequestHeader("Cookie") String cookie, @PathVariable("id") String id);

    @DeleteMapping(value = "/remove/{id}", consumes = "application/json")
    ManagerDTO removeById(@RequestHeader("Cookie") String cookie, @PathVariable("id") String id);

    @GetMapping(value = "/findAll", consumes = "application/json")
    List<ManagerDTO> findAll(@RequestHeader("Cookie") String cookie);

    @DeleteMapping(value = "/removeAll")
    void removeAll(@RequestHeader("Cookie") String cookie);

    @PostMapping(value = "/register", consumes = "application/json")
    ManagerDTO register(@RequestHeader("Cookie") String cookie,
                        @RequestHeader("login") String login,
                        @RequestHeader("password") String password);

}
