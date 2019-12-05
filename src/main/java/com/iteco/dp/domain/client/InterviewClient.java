package com.iteco.dp.domain.client;

import com.iteco.dp.domain.dto.InterviewDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("interview")
@RequestMapping(value = "/interview")
public interface InterviewClient {

    @PutMapping(value = "/update", produces = "application/json", consumes = "application/json")
    InterviewDTO update(@RequestBody InterviewDTO interviewDTO);

    @GetMapping(value = "/findAll", consumes = "application/json")
    List<InterviewDTO> findAll();

    @DeleteMapping(value = "/delete/{id}")
    void deleteById(@PathVariable("id") String id);

}
