package com.iteco.dp.domain.client;


import com.iteco.dp.domain.dto.InterviewDTO;
import com.iteco.dp.domain.dto.TeacherDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("teacher")
@RequestMapping(value = "/teacher")
public interface TeacherClient {

    @PutMapping(value = "/merge", produces = "application/json", consumes = "application/json")
    TeacherDTO merge(@RequestBody TeacherDTO teacherDTO);

    @GetMapping(value = "/find/{id}", consumes = "application/json")
    TeacherDTO findById(@PathVariable("id") String id);

    @DeleteMapping(value = "/remove/{id}", consumes = "application/json")
    TeacherDTO removeById(@PathVariable("id") String id);

    @GetMapping(value = "/findAll", consumes = "application/json")
    List<TeacherDTO> findAll();

    @DeleteMapping(value = "/removeAll")
    void removeAll();

    @GetMapping(value = "/interview", consumes = "application/json")
    InterviewDTO interview();

    @PutMapping(value = "/interview/create", produces = "application/json", consumes = "application/json")
    TeacherDTO interviewCreate(@RequestBody TeacherDTO teacherDTO);

}
