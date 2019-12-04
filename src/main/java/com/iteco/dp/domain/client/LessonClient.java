package com.iteco.dp.domain.client;

import com.iteco.dp.domain.dto.LessonDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("lesson")
@RequestMapping(value = "/lesson")
public interface LessonClient {

    @GetMapping(value = "/findAll", consumes = "application/json")
    List<LessonDTO> findAll(@RequestHeader("Cookie") String cookie);

    @GetMapping(value = "/find/{id}", consumes = "application/json")
    LessonDTO findById(@RequestHeader("Cookie") String cookie, @PathVariable("id") String id);

    @PutMapping(value = "/create", produces = "application/json", consumes = "application/json")
    LessonDTO create(@RequestHeader("Cookie") String cookie, @RequestBody LessonDTO lessonDTO);

    @PutMapping(value = "/update", produces = "application/json", consumes = "application/json")
    LessonDTO update(@RequestHeader("Cookie") String cookie, @RequestBody LessonDTO lessonDTO);

    @DeleteMapping(value = "/delete/{id}", consumes = "application/json")
    LessonDTO delete(@RequestHeader("Cookie") String cookie, @PathVariable("id") String id);

    @DeleteMapping(value = "/deleteAll")
    void deleteAll(@RequestHeader("Cookie") String cookie);

}
