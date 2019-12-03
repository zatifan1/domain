package com.iteco.dp.domain;

import com.iteco.dp.domain.client.ManagerClient;
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

@Slf4j
@RunWith(JUnit4.class)
public class ManagerTest {

    private ManagerClient managerClient;

    @Before
    public void setup(){
        managerClient = AuthResourceClient.getManagerInstance("http://localhost:8080//api");
    }

    @Test
    public void createManager() {
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
        personDTO.setSex(Sex.MALE);
        ManagerDTO managerDTO = new ManagerDTO();
        managerDTO.setId("3");
        managerDTO.setPersonDTO(personDTO);
        ManagerDTO managerDTO1 = managerClient.create(managerDTO);
        Assert.assertNotNull(managerDTO1);
    }

    @Test
    public void findByIdManager(){
        ManagerDTO managerDTO = managerClient.findById("3");
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
        ManagerDTO managerDTO = managerClient.deleteById("3");
        Assert.assertNull(managerDTO);
    }
}
