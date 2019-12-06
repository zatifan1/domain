package com.iteco.dp.domain.client;

import com.iteco.dp.domain.dto.StreamDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("stream")
@RequestMapping(value = "/stream")
public interface StreamClient {

    @GetMapping(value = "/findAll", consumes = "application/json")
    List<StreamDTO> findAll();

    @GetMapping(value = "/find/{id}", consumes = "application/json")
    StreamDTO findById(@PathVariable final String id);

    @PutMapping(value = "/create", produces = "application/json", consumes = "application/json")
    StreamDTO create(@RequestBody final StreamDTO streamDTO);

    @PutMapping(value = "/update", produces = "application/json", consumes = "application/json")
    StreamDTO update(@RequestBody final StreamDTO streamDTO);

    @DeleteMapping(value = "/delete/{id}", consumes = "application/json")
    StreamDTO deleteById(@PathVariable final String id);
}
