package com.iteco.dp.domain;

import com.iteco.dp.domain.client.ManagerClient;
import com.iteco.dp.domain.client.UserClient;
import com.iteco.dp.domain.dto.ManagerDTO;
import com.iteco.dp.domain.dto.PersonDTO;
import com.iteco.dp.domain.dto.UserDTO;
import com.iteco.dp.domain.enumeration.Sex;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Slf4j
@RunWith(JUnit4.class)
public class ManagerTest {

    private ManagerClient managerClient;
    private UserClient userClient;

    @Before
    public void setup(){
        managerClient = AuthResourceClient.getManagerInstance("http://localhost:8080//api");
        userClient = AuthResourceClient.getUserInstance("http://localhost:8080//api");
    }

    @Test
    public void findAllUser() {
        List<UserDTO> all = userClient.findAll();
        for (UserDTO userDTO : all) {
            System.out.println(userDTO.getLogin());
        }
    }

    @Test
    public void createManager() {
        ManagerDTO managerDTO1 = managerClient.create(getManagerDTO());
        Assert.assertNotNull(managerDTO1);
    }

    @Test
    public void findByIdManager(){
        ManagerDTO managerDTO = managerClient.findById("4c2897cc-c378-485b-8503-6ad25bd335c0");
        Assert.assertNotNull(managerDTO);
    }

    @Test
    public void updateManager() {
        UserDTO userDTO = new UserDTO();
        userDTO.setId("1");
        userDTO.setLogin("manager1");
        userDTO.setPassword("manager1");
        PersonDTO personDTO = new PersonDTO();
        personDTO.setId("1");
        personDTO.setBirthDate(new Date());
        personDTO.setEmail("email");
        personDTO.setFirstName("zatifan1");
        personDTO.setLastName("zatifan1");
        personDTO.setPhone("123456");
        personDTO.setUserDTO(userDTO);
        personDTO.setSex(Sex.MALE);
        System.out.println(personDTO.getId());
        ManagerDTO managerDTO = new ManagerDTO();
        managerDTO.setId("1");
        System.out.println(managerDTO.getId());
        managerDTO.setPersonDTO(personDTO);
        ManagerDTO managerDTO1 = managerClient.update(managerDTO);
        Assert.assertNotNull(managerDTO1);
    }

    @Test
    public void findAllManager() {
        List<ManagerDTO> all = managerClient.findAll();
        Assert.assertNotNull(all.get(0));
    }

    @Test
    public void deleteManager() {
        ManagerDTO managerDTO = managerClient.deleteById("4");
        Assert.assertNull(managerDTO);
    }

    private ManagerDTO getManagerDTO() {
        ManagerDTO managerDTO = new ManagerDTO();
        PersonDTO personDTO = new PersonDTO();
        UserDTO userDTO = new UserDTO();
        userDTO.setLogin("login" + new Random().nextInt());
        userDTO.setPassword("" + new Random().nextInt());
        personDTO.setFirstName("firstName" + new Random().nextInt());
        personDTO.setLastName("lastName" + new Random().nextInt());
        personDTO.setEmail("email@" + new Random().nextInt());
        personDTO.setPhone("" + new Random().nextInt());
        personDTO.setSex(Sex.MALE);
        personDTO.setUserDTO(userDTO);
        managerDTO.setPersonDTO(personDTO);
        return managerDTO;
    }
}
