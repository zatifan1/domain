package com.iteco.dp.domain.client;

import com.iteco.dp.domain.dto.PersonDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/person")
public interface PersonClient {

    @GetMapping("/findAll")
    List<PersonDTO> findAll();

    @GetMapping("/find/{id}")
    PersonDTO findOne(@PathVariable final String id);

    @PutMapping("/create")
    PersonDTO create(@RequestBody final PersonDTO personDTO);

    @PutMapping("/update")
    PersonDTO update(@RequestBody final PersonDTO personDTO);

    @DeleteMapping("/delete/{id}")
    PersonDTO delete(@PathVariable final String id);
}
