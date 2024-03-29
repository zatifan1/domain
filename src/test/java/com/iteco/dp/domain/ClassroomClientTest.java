package com.iteco.dp.domain;

import com.iteco.dp.domain.client.ClassroomClient;
import com.iteco.dp.domain.dto.ClassroomDTO;
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
public class ClassroomClientTest {

    @Autowired
    private ClassroomClient classroomClient;

    private List<ClassroomDTO> testClassrooms = new ArrayList<>();

    @After
    public void tearDown() {
        testClassrooms.forEach(e -> classroomClient.deleteById(e.getId()));
    }

    @Test
    public void findAllClassrooms() {
        @NotNull final ArrayList<ClassroomDTO> classroomDTOS = new ArrayList<>();
        IntStream.range(0, 5).forEach(e -> {
            ClassroomDTO classroomDTO = getClassroomDTO();
            testClassrooms.add(classroomDTO);
            classroomDTOS.add(classroomDTO);
            classroomClient.create(classroomDTO);
        });
        Assert.assertTrue(classroomDTOS.size() <= classroomClient.findAll().size());
    }

    @Test
    public void createClassroom() {
        @NotNull final ClassroomDTO classroomDTO = getClassroomDTO();
        testClassrooms.add(classroomDTO);
        classroomClient.create(classroomDTO);
        ReflectionAssert.assertReflectionEquals(classroomDTO, classroomClient.findById(classroomDTO.getId()));
    }

    @Test
    public void updateClassroom() {
        @NotNull final ClassroomDTO classroomDTO = getClassroomDTO();
        testClassrooms.add(classroomDTO);
        classroomDTO.setNumber("updatedNumber");
        classroomClient.update(classroomDTO);
        ReflectionAssert.assertReflectionEquals(classroomClient.findById(classroomDTO.getId()), classroomDTO);
    }

    @Test
    public void deleteClassroom() {
        @NotNull final ClassroomDTO classroomDTO = getClassroomDTO();
        classroomClient.create(classroomDTO);
        classroomClient.deleteById(classroomDTO.getId());
        Assert.assertNull(classroomClient.findById(classroomDTO.getId()));
    }

    private ClassroomDTO getClassroomDTO() {
        @NotNull final ClassroomDTO classroomDTO = new ClassroomDTO();
        classroomDTO.setNumber("" + new Random().nextInt());
        return classroomDTO;
    }
}
