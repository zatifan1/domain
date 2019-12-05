package com.iteco.dp.domain.client;

import com.iteco.dp.domain.dto.StreamDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/stream")
public interface StreamClient {

    @GetMapping(value = "/findAll")
    List<StreamDTO> findAll();

    @GetMapping(value = "/find/{id}")
    StreamDTO findById(@PathVariable final String id);

    @PutMapping(value = "/create")
    StreamDTO create(@RequestBody final StreamDTO streamDTO);

    @PutMapping(value = "/update")
    StreamDTO update(@RequestBody final StreamDTO streamDTO);

    @DeleteMapping(value = "/delete/{id}")
    StreamDTO delete(@PathVariable final String id);
}
