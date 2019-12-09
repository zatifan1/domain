package com.iteco.dp.domain;

import com.iteco.dp.domain.client.*;
import com.iteco.dp.domain.dto.*;
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
import java.util.Date;
import java.util.List;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
@TestPropertySource(locations = "classpath:application.yml")
public class StudentClientTest {

    @Autowired
    private StudentClient studentClient;

    @Autowired
    private UserClient userClient;

    @Autowired
    private PersonClient personClient;

    @Autowired
    private TeacherClient teacherClient;

    @Autowired
    private ClassroomClient classroomClient;

    @Autowired
    private StreamClient streamClient;

    @Autowired
    private CourseClient courseClient;

    private List<StudentDTO> testStudents = new ArrayList<>();
    private List<StreamDTO> testStreams = new ArrayList<>();
    private List<TeacherDTO> testTeachers = new ArrayList<>();
    private List<ClassroomDTO> testClassrooms = new ArrayList<>();
    private List<CourseDTO> testCourses = new ArrayList<>();

    @After
    public void tearDown() {
        testStudents.
                forEach(e -> studentClient.deleteById(e.getId()));
        testClassrooms.
                forEach(e -> classroomClient.deleteById(e.getId()));
        testStreams.
                forEach(e -> streamClient.deleteById(e.getId()));
        testCourses.
                forEach(e -> courseClient.deleteById(e.getId()));
        testTeachers.
                forEach(e -> teacherClient.deleteById(e.getId()));
    }

    @Test
    public void createStudent() {
        @NotNull final StudentDTO studentDTO = getStudentDTO();
        studentClient.create(studentDTO);
        ReflectionAssert.assertReflectionEquals(studentDTO, studentClient.findById(studentDTO.getId()));
    }

    @Test
    public void updateStudent() {
        @NotNull final StudentDTO studentDTO = getStudentDTO();
        studentClient.create(studentDTO);
        @NotNull final ClassroomDTO classroomDTO = new ClassroomDTO();
        testClassrooms.add(classroomDTO);
        studentDTO.setClassroomId(classroomDTO.getId());
        classroomClient.create(classroomDTO);
        studentClient.update(studentDTO);
        Assert.assertEquals(studentDTO.getClassroomId(), studentClient.findById(studentDTO.getId()).getClassroomId());
    }

    @Test
    public void deleteStudent() {
        @NotNull final StudentDTO studentDTO = getStudentDTO();
        studentClient.create(studentDTO);
        studentClient.deleteById(studentDTO.getId());
        Assert.assertNull(studentClient.findById(studentDTO.getId()));
        testStudents.remove(studentDTO);
    }

    @Test
    public void findAllStudent() {
        @NotNull final StudentDTO studentDTO = getStudentDTO();
        studentClient.create(studentDTO);
        Assert.assertTrue(studentClient.findAll().size() > 0);
    }

    @NotNull
    private StreamDTO getStreamDTO() {
        StreamDTO streamDTO = new StreamDTO();
        Date startDate = new Date();
        streamDTO.setStartDate(startDate);
        streamDTO.setCourseId(getCourseDTO().getId());
        streamClient.create(streamDTO);
        testStreams.add(streamDTO);
        return streamDTO;
    }

    @NotNull
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
        testStudents.add(studentDTO);
        return studentDTO;
    }

    @NotNull
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
        testTeachers.add(teacherDTO);
        return teacherDTO;
    }

    @NotNull
    private ClassroomDTO getClassroomDTO() {
        ClassroomDTO classroomDTO = new ClassroomDTO();
        classroomDTO.setNumber("A1");
        classroomClient.create(classroomDTO);
        testClassrooms.add(classroomDTO);
        return classroomDTO;
    }

    @NotNull
    private CourseDTO getCourseDTO() {
        CourseDTO courseDTO = new CourseDTO();
        TeacherDTO teacher = getTeacherDTO();
        courseDTO.setTeacherId(teacher.getId());
        courseDTO.setName("Course-1");
        courseClient.create(courseDTO);
        testCourses.add(courseDTO);
        return courseDTO;
    }

}
