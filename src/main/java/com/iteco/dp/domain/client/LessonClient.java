package com.iteco.dp.domain.client;

import com.iteco.dp.domain.dto.LessonDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("lesson")
@RequestMapping(value = "/lesson")
public interface LessonClient {

    @GetMapping(value = "/findAll", consumes = "application/json")
    List<LessonDTO> findAll();

    @GetMapping(value = "/find/{id}", consumes = "application/json")
    LessonDTO findById(@PathVariable("id") String id);

    @PutMapping(value = "/create", produces = "application/json", consumes = "application/json")
    LessonDTO create(@RequestBody LessonDTO lessonDTO);

    @PutMapping(value = "/update", produces = "application/json", consumes = "application/json")
    LessonDTO update(@RequestBody LessonDTO lessonDTO);

    @DeleteMapping(value = "/delete/{id}", consumes = "application/json")
    LessonDTO delete(@PathVariable("id") String id);

}
