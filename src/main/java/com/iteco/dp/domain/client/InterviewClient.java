package com.iteco.dp.domain.client;

import com.iteco.dp.domain.dto.InterviewDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@FeignClient("interview")
@RequestMapping(value = "/interview")
public interface InterviewClient {

    @PutMapping(value = "/create", produces = "application/json", consumes = "application/json")
    InterviewDTO create(@RequestBody InterviewDTO interviewDTO);

    @PutMapping(value = "/update", produces = "application/json", consumes = "application/json")
    InterviewDTO update(@RequestBody InterviewDTO interviewDTO);

    @GetMapping(value = "/find/{id}", consumes = "application/json")
    InterviewDTO findById(@PathVariable("id") String id);

    @GetMapping(value = "/findAll", consumes = "application/json")
    List<InterviewDTO> findAll();

    @DeleteMapping(value = "/delete/{id}")
    void deleteById(@PathVariable("id") String id);

    @GetMapping(value = "/find/{dateOfInterview}", consumes = "application/json")
    InterviewDTO findByDate(@PathVariable("dateOfInterview") Date dateOfInterview);

    @GetMapping(value = "/find/{teacherId}", consumes = "application/json")
    InterviewDTO findByTeacher(@PathVariable("teacherId") String teacherId);

    @GetMapping(value = "/find/{candidateId}", consumes = "application/json")
    InterviewDTO findByCandidate(@PathVariable("candidateId") String candidateId);

    @GetMapping(value = "/find/{status}", consumes = "application/json")
    InterviewDTO findByStatus(@PathVariable("status") String status);

    @GetMapping(value = "/find/{interviewGrade}", consumes = "application/json")
    InterviewDTO findByGrade(@PathVariable("interviewGrade") int interviewGrade);
}
