package com.iteco.dp.domain.client;

import com.iteco.dp.domain.dto.ManagerDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("manager")
@RequestMapping(value = "/manager")
public interface ManagerClient {

    @PutMapping(value = "/merge", produces = "application/json", consumes = "application/json")
    ManagerDTO merge(@RequestBody ManagerDTO managerDTO);

    @GetMapping(value = "/find/{id}", consumes = "application/json")
    ManagerDTO findById(@PathVariable("id") String id);

    @DeleteMapping(value = "/remove/{id}", consumes = "application/json")
    ManagerDTO removeById(@PathVariable("id") String id);

    @GetMapping(value = "/findAll", consumes = "application/json")
    List<ManagerDTO> findAll();

    @DeleteMapping(value = "/removeAll")
    void removeAll();

    @PostMapping(value = "/register", consumes = "application/json")
    ManagerDTO register(@RequestHeader("login") String login,
                        @RequestHeader("password") String password);

}
