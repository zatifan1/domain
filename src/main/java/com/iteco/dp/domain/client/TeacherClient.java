package com.iteco.dp.domain.client;

import com.iteco.dp.domain.dto.TeacherDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("teacher")
@RequestMapping(value = "/teacher")
public interface TeacherClient {

    @PutMapping(value = "/create", produces = "application/json", consumes = "application/json")
    TeacherDTO create(@RequestBody TeacherDTO teacherDTO);

    @PutMapping(value = "/update", produces = "application/json", consumes = "application/json")
    TeacherDTO update(@RequestBody TeacherDTO teacherDTO);

    @GetMapping(value = "/find/{id}", consumes = "application/json")
    TeacherDTO findById(@PathVariable("id") String id);

    @GetMapping(value = "/findAll", consumes = "application/json")
    List<TeacherDTO> findAll();

    @DeleteMapping(value = "/delete/{id}", consumes = "application/json")
    TeacherDTO deleteById(@PathVariable("id") String id);
}
