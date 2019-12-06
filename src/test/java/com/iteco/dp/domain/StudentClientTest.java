package com.iteco.dp.domain;

import com.iteco.dp.domain.client.*;
import com.iteco.dp.domain.dto.*;
import com.iteco.dp.domain.enumerated.Sex;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.unitils.reflectionassert.ReflectionAssert;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Slf4j
@RunWith(JUnit4.class)
public class StudentClientTest {

    private StudentClient studentClient;

    private UserClient userClient;

    private PersonClient personClient;

    private TeacherClient teacherClient;

    private ClassroomClient classroomClient;

    private StreamClient streamClient;

    private CourseClient courseClient;

    private List<StudentDTO> testStudents = new ArrayList<>();

    @Before
    public void setup() {
        studentClient = AuthResourceClient.getStudentInstance("http://localhost:8080//api");
        userClient = AuthResourceClient.getUserInstance("http://localhost:8080//api");
        personClient = AuthResourceClient.getPersonInstance("http://localhost:8080//api");
        teacherClient = AuthResourceClient.getTeacherInstance("http://localhost:8080//api");
        classroomClient = AuthResourceClient.getClassroomInstance("http://localhost:8080//api");
        streamClient = AuthResourceClient.getStreamInstance("http://localhost:8080//api");
        courseClient = AuthResourceClient.getCourseInstance("http://localhost:8080//api");
    }

    @After
    public void tearDown() {
        testStudents.forEach(e -> studentClient.deleteById(e.getId()));
    }

    @Test
    public void createStudent() {
        @NotNull final StudentDTO studentDTO = getStudentDTO();
        testStudents.add(studentDTO);
        studentClient.create(studentDTO);
        ReflectionAssert.assertReflectionEquals(studentDTO, studentClient.findById(studentDTO.getId()));
    }

    @NotNull
    private StreamDTO getStreamDTO() {
        StreamDTO streamDTO = new StreamDTO();
        Date startDate = new Date();
        streamDTO.setStartDate(startDate);
        streamDTO.setCourseId(getCourseDTO().getId());
        streamClient.create(streamDTO);
        return streamDTO;
    }

    private StudentDTO getStudentDTO() {
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

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setPersonId(personDTO.getId());
        studentDTO.setTeacherId(getTeacherDTO().getId());
        studentDTO.setClassroomId(getClassroomDTO().getId());
        studentDTO.setStreamId(getStreamDTO().getId());
        return studentDTO;
    }

    private TeacherDTO getTeacherDTO() {
        TeacherDTO teacherDTO = new TeacherDTO();

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

        teacherDTO.setPersonId(personDTO.getId());
        teacherClient.create(teacherDTO);
        return teacherDTO;
    }

    private ClassroomDTO getClassroomDTO() {
        ClassroomDTO classroomDTO = new ClassroomDTO();
        classroomDTO.setNumber("A1");
        classroomClient.create(classroomDTO);
        return classroomDTO;
    }

    @NotNull
    private CourseDTO getCourseDTO() {
        CourseDTO courseDTO = new CourseDTO();
        TeacherDTO teacher = getTeacherDTO();
        courseDTO.setTeacherId(teacher.getId());
        courseDTO.setName("Course-1");
        courseClient.create(courseDTO);
        return courseDTO;
    }


}
