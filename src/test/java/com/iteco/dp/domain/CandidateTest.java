package com.iteco.dp.domain;

import com.iteco.dp.domain.client.CandidateClient;
import com.iteco.dp.domain.dto.CandidateDTO;
import com.iteco.dp.domain.dto.PersonDTO;
import com.iteco.dp.domain.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Date;

@Slf4j
@RunWith(JUnit4.class)
public class CandidateTest {

    private CandidateClient candidateClient;

    @Before
    public void setup(){
        candidateClient = AuthResourceClient.getCandidateInstance("http://localhost:8080//api");
    }

    @Test
    public void createCandidate(){
        UserDTO userDTO = new UserDTO();
        userDTO.setId("1");
        userDTO.setLogin("manager1");
        userDTO.setPassword("manager1");
        PersonDTO personDTO = new PersonDTO();
        personDTO.setId("2");
        personDTO.setBirthDate(new Date());
        personDTO.setEmail("email");
        personDTO.setFirstName("zatifan");
        personDTO.setLastName("zatifan");
        personDTO.setPhone("123456");
        personDTO.setUserDTO(userDTO);
        CandidateDTO candidateDTO = new CandidateDTO();
        candidateDTO.setId("3");
        candidateDTO.setPersonDTO(personDTO);
        CandidateDTO candidateDTO1 = candidateClient.create(candidateDTO);
        Assert.assertNotNull(candidateDTO1);
    }


    @Test
    public void updateCandidate(){
        UserDTO userDTO = new UserDTO();
        userDTO.setId("1");
        userDTO.setLogin("candidate");
        userDTO.setPassword("candidate");
        PersonDTO personDTO = new PersonDTO();
        personDTO.setId("2");
        personDTO.setBirthDate(new Date());
        personDTO.setEmail("email");
        personDTO.setFirstName("zatifan");
        personDTO.setLastName("zatifan");
        personDTO.setPhone("123456");
        personDTO.setUserDTO(userDTO);
        CandidateDTO candidateDTO = new CandidateDTO();
        candidateDTO.setId("3");
        candidateDTO.setPersonDTO(personDTO);
        CandidateDTO candidateDTO1 = candidateClient.update(candidateDTO);
        Assert.assertEquals(candidateDTO1.getPersonDTO().getUserDTO().getLogin(),userDTO.getLogin());
    }

    @Test
    public void findByIdCandidate(){
        CandidateDTO candidateDTO = candidateClient.findById("3");
        Assert.assertNotNull(candidateDTO);
    }

    @Test
    public void deleteCandidate(){
        CandidateDTO candidateDTO = candidateClient.deleteById("3");
        Assert.assertNull(candidateDTO);
    }

}
