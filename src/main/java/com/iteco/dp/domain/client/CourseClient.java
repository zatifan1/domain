package com.iteco.dp.domain.client;

import com.iteco.dp.domain.dto.CourseDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/course")
public interface CourseClient {

    @GetMapping(value = "/findAll")
    List<CourseDTO> findAll();

    @GetMapping(value = "/find/{id}")
    CourseDTO findById(@PathVariable final String id);

    @PutMapping(value = "/create")
    CourseDTO create(@RequestBody final CourseDTO courseDTO);

    @PutMapping(value = "/update")
    CourseDTO update(@RequestBody final CourseDTO courseDTO);

    @DeleteMapping(value = "/delete/{id}")
    CourseDTO delete(@PathVariable final String id);
}
