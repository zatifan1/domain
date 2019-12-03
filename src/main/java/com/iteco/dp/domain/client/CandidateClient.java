package com.iteco.dp.domain.client;

import com.iteco.dp.domain.dto.CandidateDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("candidate")
@RequestMapping(value = "/candidate")
public interface CandidateClient {

    @PutMapping(value = "/create", produces = "application/json", consumes = "application/json")
    CandidateDTO create(@RequestBody CandidateDTO candidateDTO);

    @PutMapping(value = "/update", produces = "application/json", consumes = "application/json")
    CandidateDTO update(@RequestBody CandidateDTO candidateDTO);

    @GetMapping(value = "/find/{id}", consumes = "application/json")
    CandidateDTO findById(@PathVariable("id") String id);

    @DeleteMapping(value = "/delete/{id}")
    CandidateDTO deleteById(@PathVariable("id") String id);

    @GetMapping(value = "/findAll", consumes = "application/json")
    List<CandidateDTO> findAll();

}