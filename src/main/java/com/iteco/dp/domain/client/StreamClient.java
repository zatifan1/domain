package com.iteco.dp.domain.client;

import com.iteco.dp.domain.dto.StreamDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value = "/stream")
public interface StreamClient {

    @GetMapping(value = "/findAll")
    ResponseEntity<Collection<StreamDTO>> findAll();

    @GetMapping(value = "/find/{id}")
    ResponseEntity<StreamDTO> findById(@PathVariable final String id);

    @PutMapping(value = "/create")
    ResponseEntity<StreamDTO> create(@RequestBody final StreamDTO streamDTO);

    @PutMapping(value = "/update")
    ResponseEntity<StreamDTO> update(@RequestBody final StreamDTO streamDTO);

    @DeleteMapping(value = "/delete/{id}")
    ResponseEntity delete(@PathVariable final String id);
}
