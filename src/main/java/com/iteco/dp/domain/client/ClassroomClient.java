package com.iteco.dp.domain.client;

import com.iteco.dp.domain.dto.ClassroomDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("classroom")
@RequestMapping(value = "/classroom")
public interface ClassroomClient {

    @PutMapping(value = "/create", produces = "application/json", consumes = "application/json")
    ClassroomDTO create(@RequestBody ClassroomDTO classroomDTO);

    @PutMapping(value = "/update", produces = "application/json", consumes = "application/json")
    ClassroomDTO update(@RequestBody ClassroomDTO classroomDTO);

    @GetMapping(value = "/find/{id}", consumes = "application/json")
    ClassroomDTO findById(@PathVariable("id") String id);

    @DeleteMapping(value = "/delete/{id}")
    ClassroomDTO removeById(@PathVariable("id") String id);

    @GetMapping(value = "/findAll", consumes = "application/json")
    List<ClassroomDTO> findAll();

    @DeleteMapping(value = "/deleteAll")
    void deleteAll();

}
