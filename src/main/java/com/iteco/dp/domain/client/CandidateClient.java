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
    CandidateDTO merge(@RequestBody CandidateDTO candidateDTO);

    @GetMapping(value = "/find/{id}", consumes = "application/json")
    CandidateDTO findById(@PathVariable("id") String id);

    @DeleteMapping(value = "/remove/{id}")
    CandidateDTO removeById(@PathVariable("id") String id);

    @GetMapping(value = "/findAll", consumes = "application/json")
    List<CandidateDTO> findAll();

    @DeleteMapping(value = "/removeAll")
    void removeAll();

    @GetMapping(value = "/interview")
    InterviewDTO interview();
}