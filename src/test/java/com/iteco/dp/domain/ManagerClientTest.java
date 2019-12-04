package com.iteco.dp.domain;

import com.iteco.dp.domain.client.ManagerClient;
import com.iteco.dp.domain.dto.ManagerDTO;
import com.iteco.dp.domain.dto.PersonDTO;
import com.iteco.dp.domain.dto.UserDTO;
import com.iteco.dp.domain.enumeration.Sex;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.unitils.reflectionassert.ReflectionAssert;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Slf4j
@RunWith(JUnit4.class)
public class ManagerClientTest {

    private ManagerClient managerClient;

    private List<ManagerDTO> testManagers = new ArrayList<>();

    @Before
    public void setup() {
        managerClient = AuthResourceClient.getManagerInstance("http://localhost:8080//api");
    }

    @After
    public void tearDown() {
        testManagers.forEach(e -> managerClient.deleteById(e.getId()));
    }

    @Test
    public void findAllManagers() {
        @NotNull final ArrayList<ManagerDTO> managerDTOS = new ArrayList<>();
        IntStream.range(0, 5).forEach(e -> {
            ManagerDTO managerDTO = getManagerDTO();
            testManagers.add(managerDTO);
            managerDTOS.add(managerDTO);
            managerClient.create(managerDTO);
        });
        Assert.assertEquals(managerDTOS.size(), managerClient.findAll().size());
    }

    @Test
    public void createManager() {
        @NotNull final ManagerDTO managerDTO = getManagerDTO();
        testManagers.add(managerDTO);
        managerClient.create(managerDTO);
        ReflectionAssert.assertReflectionEquals(managerDTO, managerClient.findById(managerDTO.getId()));
    }

    @Test
    public void updateManager() {
        @NotNull final ManagerDTO managerDTO = getManagerDTO();
        testManagers.add(managerDTO);
        managerClient.create(managerDTO);
        managerDTO.getPersonDTO().setFirstName("UPDATED");
        managerClient.update(managerDTO);
        ReflectionAssert.assertReflectionEquals(managerDTO, managerClient.findById(managerDTO.getId()));
    }

    @Test
    public void deleteManager() {
        @NotNull final ManagerDTO managerDTO = getManagerDTO();
        managerClient.create(managerDTO);
        managerClient.deleteById(managerDTO.getId());
        Assert.assertNull(managerClient.findById(managerDTO.getId()));
    }

    private ManagerDTO getManagerDTO() {
        @NotNull final UserDTO userDTO = new UserDTO();
        userDTO.setLogin("" + new Random().nextInt());
        userDTO.setPassword("manager1" + new Random().nextInt());
        @NotNull final PersonDTO personDTO = new PersonDTO();
        personDTO.setBirthDate(new Date());
        personDTO.setEmail("email" + new Random().nextInt());
        personDTO.setFirstName("zatifan1" + new Random().nextInt());
        personDTO.setLastName("zatifan1" + new Random().nextInt());
        personDTO.setPhone("123456" + new Random().nextInt());
        personDTO.setUserDTO(userDTO);
        personDTO.setSex(Sex.MALE);
        ManagerDTO managerDTO = new ManagerDTO();
        managerDTO.setPersonDTO(personDTO);
        return managerDTO;
    }
}
