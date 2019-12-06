package com.iteco.dp.domain.client;

import com.iteco.dp.domain.dto.CourseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("course")
@RequestMapping(value = "/course")
public interface CourseClient {

    @GetMapping(value = "/findAll", consumes = "application/json")
    List<CourseDTO> findAll();

    @GetMapping(value = "/find/{id}", consumes = "application/json")
    CourseDTO findById(@PathVariable final String id);

    @PutMapping(value = "/create", produces = "application/json", consumes = "application/json")
    CourseDTO create(@RequestBody final CourseDTO courseDTO);

    @PutMapping(value = "/update", produces = "application/json", consumes = "application/json")
    CourseDTO update(@RequestBody final CourseDTO courseDTO);

    @DeleteMapping(value = "/delete/{id}", consumes = "application/json")
    CourseDTO deleteById(@PathVariable final String id);
}
