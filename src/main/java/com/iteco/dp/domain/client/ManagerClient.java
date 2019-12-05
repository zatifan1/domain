package com.iteco.dp.domain.client;

import com.iteco.dp.domain.dto.ManagerDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("manager")
@RequestMapping(value = "manager")
public interface ManagerClient {

    @PutMapping(value = "/create", produces = "application/json", consumes = "application/json")
    ManagerDTO create(@RequestBody ManagerDTO managerDTO);

    @PutMapping(value = "/update", produces = "application/json", consumes = "application/json")
    ManagerDTO update(@RequestBody ManagerDTO managerDTO);

    @GetMapping(value = "/find/{id}", consumes = "application/json")
    ManagerDTO findById(@PathVariable("id") String id);

    @DeleteMapping(value = "/delete/{id}", consumes = "application/json")
    ManagerDTO deleteById(@PathVariable("id") String id);

    @GetMapping(value = "/findAll", consumes = "application/json")
    List<ManagerDTO> findAll();

}
