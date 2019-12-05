package com.iteco.dp.domain.client;

import com.iteco.dp.domain.dto.PersonDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value = "/person")
public interface PersonClient {

    @GetMapping("/findAll")
    ResponseEntity<Collection<PersonDTO>> findAll();

    @GetMapping("/find/{id}")
    ResponseEntity<PersonDTO> findOne(@PathVariable final String id);

    @PutMapping("/create")
    ResponseEntity<PersonDTO> create(@RequestBody final PersonDTO personDTO);

    @PutMapping("/update")
    ResponseEntity<PersonDTO> update(@RequestBody final PersonDTO personDTO);

    @DeleteMapping("/delete/{id}")
    ResponseEntity delete(@PathVariable final String id);
}
