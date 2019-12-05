package com.iteco.dp.domain.client;

import com.iteco.dp.domain.dto.PersonDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/person")
public interface PersonClient {

    @GetMapping(value = "/findAll", consumes = "application/json")
    List<PersonDTO> findAll();

    @GetMapping(value = "/find/{id}", consumes = "application/json")
    PersonDTO findById(@PathVariable final String id);

    @PutMapping(value = "/create", produces = "application/json", consumes = "application/json")
    PersonDTO create(@RequestBody final PersonDTO personDTO);

    @PutMapping(value = "/update", produces = "application/json", consumes = "application/json")
    PersonDTO update(@RequestBody final PersonDTO personDTO);

    @DeleteMapping(value = "/delete/{id}", consumes = "application/json")
    PersonDTO deleteById(@PathVariable final String id);
}
