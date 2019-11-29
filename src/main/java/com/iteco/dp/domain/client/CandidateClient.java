package com.iteco.dp.domain.client;

import com.iteco.dp.domain.dto.CandidateDTO;
import com.iteco.dp.domain.dto.InterviewDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("candidate")
@RequestMapping(value = "/candidate")
public interface CandidateClient {

    @PutMapping(value = "/merge", produces = "application/json", consumes = "application/json")
    CandidateDTO merge(@RequestHeader("Cookie") String cookie, @RequestBody CandidateDTO candidateDTO);

    @GetMapping(value = "/find/{id}", consumes = "application/json")
    CandidateDTO findById(@RequestHeader("Cookie") String cookie, @PathVariable("id") String id);

    @DeleteMapping(value = "/remove/{id}")
    CandidateDTO removeById(@RequestHeader("Cookie") String cookie, @PathVariable("id") String id);

    @GetMapping(value = "/findAll", consumes = "application/json")
    List<CandidateDTO> findAll(@RequestHeader("Cookie") String cookie);

    @DeleteMapping(value = "/removeAll")
    void removeAll(@RequestHeader("Cookie") String cookie);

    @GetMapping(value = "/interview")
    InterviewDTO interview(@RequestHeader("Cookie") String cookie);
}