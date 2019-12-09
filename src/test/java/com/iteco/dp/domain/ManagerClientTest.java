package com.iteco.dp.domain;

import com.iteco.dp.domain.client.ManagerClient;
import com.iteco.dp.domain.client.PersonClient;
import com.iteco.dp.domain.client.UserClient;
import com.iteco.dp.domain.dto.ManagerDTO;
import com.iteco.dp.domain.dto.PersonDTO;
import com.iteco.dp.domain.dto.UserDTO;
import com.iteco.dp.domain.enumerated.Sex;
import org.jetbrains.annotations.NotNull;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.unitils.reflectionassert.ReflectionAssert;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
@TestPropertySource(locations = "classpath:application.yml")
public class ManagerClientTest {

    @Autowired
    private ManagerClient managerClient;

    @Autowired
    private UserClient userClient;

    @Autowired
    private PersonClient personClient;

    private List<ManagerDTO> testManagers = new ArrayList<>();

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
        //TODO добавить изменения
//        managerDTO.getPersonDTO().setFirstName("UPDATED");
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
        UserDTO userDTO = new UserDTO();
        userDTO.setLogin("login" + new Random().nextInt());
        userDTO.setPassword("" + new Random().nextInt());
        userClient.create(userDTO);

        PersonDTO personDTO = new PersonDTO();
        personDTO.setFirstName("firstName" + new Random().nextInt());
        personDTO.setLastName("lastName" + new Random().nextInt());
        personDTO.setEmail("email@" + new Random().nextInt());
        personDTO.setPhone("" + new Random().nextInt());
        personDTO.setSex(Sex.MALE);
        personDTO.setUserId(userDTO.getId());
        personClient.create(personDTO);

        ManagerDTO managerDTO = new ManagerDTO();
        managerDTO.setPersonId(personDTO.getId());
        return managerDTO;
    }
}
