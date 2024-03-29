package com.iteco.dp.domain;

import com.iteco.dp.domain.client.CandidateClient;
import com.iteco.dp.domain.client.PersonClient;
import com.iteco.dp.domain.client.UserClient;
import com.iteco.dp.domain.dto.CandidateDTO;
import com.iteco.dp.domain.dto.PersonDTO;
import com.iteco.dp.domain.dto.UserDTO;
import com.iteco.dp.domain.enumerated.Sex;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.unitils.reflectionassert.ReflectionAssert;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
@TestPropertySource(locations = "classpath:application.yml")
public class CandidateClientTest {

    @Autowired
    private CandidateClient candidateClient;

    @Autowired
    private UserClient userClient;

    @Autowired
    private PersonClient personClient;

    private List<CandidateDTO> testCandidates = new ArrayList<>();

    @After
    public void tearDown() {
        testCandidates.forEach(e -> candidateClient.deleteById(e.getId()));
    }

    @Test
    public void findAllCandidates() {
        @NotNull final ArrayList<CandidateDTO> candidateDTOS = new ArrayList<>();
        IntStream.range(0, 5).forEach(e -> {
            CandidateDTO candidateDTO = getCandidateDTO();
            testCandidates.add(candidateDTO);
            candidateDTOS.add(candidateDTO);
            candidateClient.create(candidateDTO);
        });
        Assert.assertEquals(candidateDTOS.size(), candidateClient.findAll().size());
    }

    @Test
    public void createCandidate() {
        @NotNull final CandidateDTO candidateDTO = getCandidateDTO();
        testCandidates.add(candidateDTO);
        candidateClient.create(candidateDTO);
        ReflectionAssert.assertReflectionEquals(candidateDTO, candidateClient.findById(candidateDTO.getId()));
    }

    @Test
    public void updateCandidate() {
        @NotNull final CandidateDTO candidateDTO = getCandidateDTO();
        testCandidates.add(candidateDTO);
        candidateClient.create(candidateDTO);
        //TODO добавить изменения
//        candidateDTO.getPersonDTO().setFirstName("UPDATED");
        candidateClient.update(candidateDTO);
        ReflectionAssert.assertReflectionEquals(candidateDTO, candidateClient.findById(candidateDTO.getId()));
    }

    @Test
    public void deleteCandidate() {
        @NotNull final CandidateDTO candidateDTO = getCandidateDTO();
        candidateClient.create(candidateDTO);
        candidateClient.deleteById(candidateDTO.getId());
        Assert.assertNull(candidateClient.findById(candidateDTO.getId()));
    }

    private CandidateDTO getCandidateDTO() {
        UserDTO userDTO = new UserDTO();
        userDTO.setLogin("login" + new Random().nextInt());
        userDTO.setPassword("" + new Random().nextInt());
        userClient.update(userDTO);

        PersonDTO personDTO = new PersonDTO();
        personDTO.setFirstName("firstName" + new Random().nextInt());
        personDTO.setLastName("lastName" + new Random().nextInt());
        personDTO.setEmail("email@" + new Random().nextInt());
        personDTO.setPhone("" + new Random().nextInt());
        personDTO.setSex(Sex.MALE);
        personDTO.setUserId(userDTO.getId());
        personClient.create(personDTO);

        CandidateDTO candidateDTO = new CandidateDTO();
        candidateDTO.setPersonId(personDTO.getId());
        return candidateDTO;
    }
}
