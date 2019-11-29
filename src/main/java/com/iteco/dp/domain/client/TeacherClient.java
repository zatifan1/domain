package com.iteco.dp.domain.client;


import com.iteco.dp.domain.dto.InterviewDTO;
import com.iteco.dp.domain.dto.TeacherDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("teacher")
@RequestMapping(value = "/teacher")
public interface TeacherClient {

    @PutMapping(value = "/merge", produces = "application/json", consumes = "application/json")
    TeacherDTO merge(@RequestHeader("Cookie") String cookie,
                     @RequestBody TeacherDTO teacherDTO);

    @GetMapping(value = "/find/{id}", consumes = "application/json")
    TeacherDTO findById(@RequestHeader("Cookie") String cookie,
                        @PathVariable("id") String id);

    @DeleteMapping(value = "/remove/{id}", consumes = "application/json")
    TeacherDTO removeById(@RequestHeader("Cookie") String cookie,
                          @PathVariable("id") String id);

    @GetMapping(value = "/findAll", consumes = "application/json")
    List<TeacherDTO> findAll(@RequestHeader("Cookie") String cookie);

    @DeleteMapping(value = "/removeAll")
    void removeAll(@RequestHeader("Cookie") String cookie);

    @GetMapping(value = "/interview", consumes = "application/json")
    InterviewDTO interview(@RequestHeader("Cookie") String cookie);

    @PutMapping(value = "/interview/create", produces = "application/json", consumes = "application/json")
    TeacherDTO interviewCreate(@RequestHeader("Cookie") String cookie,
                               @RequestBody TeacherDTO teacherDTO);

}
