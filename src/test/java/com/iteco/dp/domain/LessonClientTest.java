package com.iteco.dp.domain;

import com.iteco.dp.domain.client.*;
import com.iteco.dp.domain.dto.*;
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
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
@TestPropertySource(locations = "classpath:application.yml")
public class LessonClientTest {

    @Autowired
    private LessonClient lessonClient;

    @Autowired
    private UserClient userClient;

    @Autowired
    private PersonClient personClient;

    @Autowired
    private TeacherClient teacherClient;

    @Autowired
    private CourseClient courseClient;

    private List<LessonDTO> testLessons = new ArrayList<>();

    @After
    public void tearDown() {
        testLessons.forEach(e -> lessonClient.deleteById(e.getId()));
    }

    @Test
    public void findAllLessons() {
        @NotNull final ArrayList<LessonDTO> lessonDTOS = new ArrayList<>();
        IntStream.range(0, 5).forEach(e -> {
            LessonDTO lessonDTO = getLessonDTO();
            testLessons.add(lessonDTO);
            lessonDTOS.add(lessonDTO);
            lessonClient.create(lessonDTO);
        });
        Assert.assertEquals(lessonDTOS.size(), lessonClient.findAll().size());
    }

    @Test
    public void createLesson() {
        @NotNull final LessonDTO lessonDTO = getLessonDTO();
        testLessons.add(lessonDTO);
        lessonClient.create(lessonDTO);
        ReflectionAssert.assertReflectionEquals(lessonDTO, lessonClient.findById(lessonDTO.getId()));
    }

    @Test
    public void updateLesson() {
        @NotNull final LessonDTO lessonDTO = getLessonDTO();
        testLessons.add(lessonDTO);
        lessonDTO.setName("update-test");
        lessonClient.update(lessonDTO);
        ReflectionAssert.assertReflectionEquals(lessonClient.findById(lessonDTO.getId()), lessonDTO);
    }

    @Test
    public void deleteLesson() {
        @NotNull final LessonDTO lessonDTO = getLessonDTO();
        lessonClient.create(lessonDTO);
        lessonClient.deleteById(lessonDTO.getId());
        Assert.assertNull(lessonClient.findById(lessonDTO.getId()));
    }

    @NotNull
    private LessonDTO getLessonDTO() {
        LessonDTO lessonDTO = new LessonDTO();
        lessonDTO.setName("name");
        lessonDTO.setDescription("description");

        UserDTO UserTeacher = getUserDTO("UserTeacher");
        PersonDTO personTeacher = getPersonDTO(UserTeacher);
        TeacherDTO teacherDTO = new TeacherDTO();
        teacherDTO.setPersonId(personTeacher.getId());
        teacherClient.create(teacherDTO);
        @NotNull final CourseDTO courseDTO = new CourseDTO();
        courseDTO.setTeacherId(teacherDTO.getId());
        courseClient.create(courseDTO);
        lessonDTO.setCourseId(courseDTO.getId());
        lessonDTO.setSourceUrl("url");

        return lessonDTO;
    }

    @NotNull
    private PersonDTO getPersonDTO(UserDTO userDTO) {
        PersonDTO personDTO = new PersonDTO();
        personDTO.setFirstName(userDTO.getLogin());
        personDTO.setSex(Sex.MALE);
        personDTO.setUserId(userDTO.getId());
        personClient.create(personDTO);
        return personDTO;
    }

    @NotNull
    private UserDTO getUserDTO(@NotNull String login) {
        UserDTO userDTO = new UserDTO();
        userDTO.setLogin("login" + new Random().nextInt());
        userDTO.setPassword("" + new Random().nextInt());
        userClient.update(userDTO);
        return userDTO;
    }
}
