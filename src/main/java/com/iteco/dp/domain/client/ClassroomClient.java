package com.iteco.dp.domain.client;

import com.iteco.dp.domain.dto.CandidateDTO;
import com.iteco.dp.domain.dto.ClassroomDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("classroom")
@RequestMapping(value = "/classroom")
public interface ClassroomClient {

    @PutMapping(value = "/create", produces = "application/json", consumes = "application/json")
    ClassroomDTO create(@RequestHeader("Cookie") String cookie, @RequestBody ClassroomDTO classroomDTO);

    @PutMapping(value = "/update", produces = "application/json", consumes = "application/json")
    ClassroomDTO update(@RequestHeader("Cookie") String cookie, @RequestBody ClassroomDTO classroomDTO);

    @GetMapping(value = "/find/{id}", consumes = "application/json")
    ClassroomDTO findById(@RequestHeader("Cookie") String cookie, @PathVariable("id") String id);

    @DeleteMapping(value = "/delete/{id}")
    ClassroomDTO removeById(@RequestHeader("Cookie") String cookie, @PathVariable("id") String id);

    @GetMapping(value = "/findAll", consumes = "application/json")
    List<ClassroomDTO> findAll(@RequestHeader("Cookie") String cookie);

    @DeleteMapping(value = "/deleteAll")
    void deleteAll(@RequestHeader("Cookie") String cookie);

}
