package com.iteco.dp.domain.client;

import com.iteco.dp.domain.dto.CourseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value = "/course")
public interface CourseClient {

    @GetMapping(value = "/findAll")
    ResponseEntity<Collection<CourseDTO>> findAll();

    @GetMapping(value = "/find/{id}")
    ResponseEntity<CourseDTO> findById(@PathVariable final String id);

    @PutMapping(value = "/create")
    ResponseEntity<CourseDTO> create(@RequestBody final CourseDTO courseDTO);

    @PutMapping(value = "/update")
    ResponseEntity<CourseDTO> update(@RequestBody final CourseDTO courseDTO);

    @DeleteMapping(value = "/delete/{id}")
    ResponseEntity delete(@PathVariable final String id);
}
