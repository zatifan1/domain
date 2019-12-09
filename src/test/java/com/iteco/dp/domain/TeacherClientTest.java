package com.iteco.dp.domain;

import com.iteco.dp.domain.client.PersonClient;
import com.iteco.dp.domain.client.TeacherClient;
import com.iteco.dp.domain.client.UserClient;
import com.iteco.dp.domain.dto.PersonDTO;
import com.iteco.dp.domain.dto.TeacherDTO;
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
public class TeacherClientTest {

    @Autowired
    private TeacherClient teacherClient;

    @Autowired
    private UserClient userClient;

    @Autowired
    private PersonClient personClient;

    private List<TeacherDTO> testTeachers = new ArrayList<>();

    @After
    public void tearDown() {
        testTeachers.forEach(e -> teacherClient.deleteById(e.getId()));
    }

    @Test
    public void findAllTeachers() {
        @NotNull final ArrayList<TeacherDTO> teacherDTOS = new ArrayList<>();
        IntStream.range(0, 5).forEach(e -> {
            TeacherDTO teacherDTO = getTeacherDTO();
            testTeachers.add(teacherDTO);
            teacherDTOS.add(teacherDTO);
            teacherClient.create(teacherDTO);
        });
        Assert.assertTrue(teacherDTOS.size() < teacherClient.findAll().size());
    }

    @Test
    public void createTeacher() {
        @NotNull final TeacherDTO teacherDTO = getTeacherDTO();
        testTeachers.add(teacherDTO);
        teacherClient.create(teacherDTO);
        ReflectionAssert.assertReflectionEquals(teacherDTO, teacherClient.findById(teacherDTO.getId()));
    }

    @Test
    public void updateTeacher() {
        @NotNull final TeacherDTO teacherDTO = getTeacherDTO();
        testTeachers.add(teacherDTO);
        //TODO добавить изменения
//        teacherDTO.getPersonDTO().setFirstName("A2");
        teacherClient.update(teacherDTO);
        ReflectionAssert.assertReflectionEquals(teacherClient.findById(teacherDTO.getId()), teacherDTO);
    }

    @Test
    public void deleteTeacher() {
        @NotNull final TeacherDTO teacherDTO = getTeacherDTO();
        teacherClient.create(teacherDTO);
        teacherClient.deleteById(teacherDTO.getId());
        Assert.assertNull(teacherClient.findById(teacherDTO.getId()));
    }

    private TeacherDTO getTeacherDTO() {
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
        TeacherDTO teacherDTO = new TeacherDTO();
        teacherDTO.setPersonId(personDTO.getId());
        return teacherDTO;
    }
}
