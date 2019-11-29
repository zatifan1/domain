package com.iteco.dp.domain.client;

import com.iteco.dp.domain.dto.InterviewDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("interview")
@RequestMapping(value = "/interview")
public interface InterviewClient {

    @PutMapping(value = "/merge", produces = "application/json", consumes = "application/json")
    InterviewDTO merge(@RequestHeader("Cookie") String cookie, @RequestBody InterviewDTO interviewDTO);

    @GetMapping(value = "/findAll", consumes = "application/json")
    List<InterviewDTO> findAll(@RequestHeader("Cookie") String cookie);

    @DeleteMapping(value = "/remove/{id}")
    void remove(@RequestHeader("Cookie") String cookie, @PathVariable("id") String id);

    @DeleteMapping(value = "/removeAll")
    void removeAll(@RequestHeader("Cookie") String cookie);

}
