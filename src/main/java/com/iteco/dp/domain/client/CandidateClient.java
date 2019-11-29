package com.iteco.dp.domain.client;

import com.iteco.dp.domain.dto.CandidateDTO;
import com.iteco.dp.domain.dto.InterviewDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("candidate")
@RequestMapping(value = "/candidate")
public interface CandidateClient {

    @PutMapping(value = "/create", produces = "application/json", consumes = "application/json")
    CandidateDTO create(@RequestHeader("Cookie") String cookie, @RequestBody CandidateDTO candidateDTO);

    @PutMapping(value = "/update", produces = "application/json", consumes = "application/json")
    CandidateDTO update(@RequestHeader("Cookie") String cookie, @RequestBody CandidateDTO candidateDTO);

    @GetMapping(value = "/find/{id}", consumes = "application/json")
    CandidateDTO findById(@RequestHeader("Cookie") String cookie, @PathVariable("id") String id);

    @DeleteMapping(value = "/delete/{id}")
    CandidateDTO removeById(@RequestHeader("Cookie") String cookie, @PathVariable("id") String id);

    @GetMapping(value = "/findAll", consumes = "application/json")
    List<CandidateDTO> findAll(@RequestHeader("Cookie") String cookie);

    @DeleteMapping(value = "/deleteAll")
    void deleteAll(@RequestHeader("Cookie") String cookie);

}