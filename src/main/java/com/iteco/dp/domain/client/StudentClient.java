package com.iteco.dp.domain.client;

import com.iteco.dp.domain.dto.StudentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("student")
@RequestMapping(value = "/student")
public interface StudentClient {

    @PutMapping(value = "/create", produces = "application/json", consumes = "application/json")
    StudentDTO create(@RequestBody StudentDTO studentDTO);

    @PutMapping(value = "/update", produces = "application/json", consumes = "application/json")
    StudentDTO update(@RequestBody StudentDTO studentDTO);

    @GetMapping(value = "/find/{id}", consumes = "application/json")
    StudentDTO findById(@PathVariable("id") String id);

    @DeleteMapping(value = "/delete/{id}")
    StudentDTO deleteById(@PathVariable("id") String id);

    @GetMapping(value = "/findAll", consumes = "application/json")
    List<StudentDTO> findAll();

}
