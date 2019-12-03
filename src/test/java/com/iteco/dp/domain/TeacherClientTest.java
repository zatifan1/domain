package com.iteco.dp.domain;

import com.iteco.dp.domain.client.TeacherClient;
import com.iteco.dp.domain.dto.PersonDTO;
import com.iteco.dp.domain.dto.TeacherDTO;
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
public class TeacherClientTest {

    private TeacherClient teacherClient;

    private List<TeacherDTO> testTeachers = new ArrayList<>();

    @Before
    public void setup() {
        teacherClient = AuthResourceClient.getTeacherInstance("http://localhost:8080//api");
    }

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
        Assert.assertEquals(teacherDTOS.size(), teacherClient.findAll().size());
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
        teacherDTO.getPersonDTO().setFirstName("A2");
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
        @NotNull final UserDTO userDTO = new UserDTO();
        userDTO.setLogin("" + new Random().nextInt());
        userDTO.setPassword("" + new Random().nextInt());
        @NotNull final PersonDTO personDTO = new PersonDTO();
        personDTO.setBirthDate(new Date());
        personDTO.setEmail("email" + new Random().nextInt());
        personDTO.setFirstName("zatifan1" + new Random().nextInt());
        personDTO.setLastName("zatifan1" + new Random().nextInt());
        personDTO.setPhone("123456" + new Random().nextInt());
        personDTO.setUserDTO(userDTO);
        personDTO.setSex(Sex.MALE);
        TeacherDTO teacherDTO = new TeacherDTO();
        teacherDTO.setPersonDTO(personDTO);
        return teacherDTO;
    }
}
