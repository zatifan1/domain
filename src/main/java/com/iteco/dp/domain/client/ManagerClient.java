package com.iteco.dp.domain.client;

import com.iteco.dp.domain.dto.ManagerDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("manager")
@RequestMapping(value = "/manager")
public interface ManagerClient {

    @PutMapping(value = "/create", produces = "application/json", consumes = "application/json")
    ManagerDTO merge(@RequestHeader("Cookie") String cookie, @RequestBody ManagerDTO managerDTO);

    @PutMapping(value = "/update", produces = "application/json", consumes = "application/json")
    ManagerDTO update(@RequestHeader("Cookie") String cookie, @RequestBody ManagerDTO managerDTO);

    @GetMapping(value = "/find/{id}", consumes = "application/json")
    ManagerDTO findById(@RequestHeader("Cookie") String cookie, @PathVariable("id") String id);

    @DeleteMapping(value = "/delete/{id}", consumes = "application/json")
    ManagerDTO removeById(@RequestHeader("Cookie") String cookie, @PathVariable("id") String id);

    @GetMapping(value = "/findAll", consumes = "application/json")
    List<ManagerDTO> findAll(@RequestHeader("Cookie") String cookie);

    @DeleteMapping(value = "/deleteAll")
    void removeAll(@RequestHeader("Cookie") String cookie);

}
