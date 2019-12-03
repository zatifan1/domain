package com.iteco.dp.domain;

import com.iteco.dp.domain.client.ClassroomClient;
import com.iteco.dp.domain.dto.ClassroomDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@Slf4j
@RunWith(JUnit4.class)
public class ClassroomTest {

    private ClassroomClient classroomClient;

    @Before
    public void setup() {
        classroomClient = AuthResourceClient.getClassroomInstance("http://localhost:8080//api");
    }

    @Test
    public void createClassroom() {
        ClassroomDTO classroomDTO = new ClassroomDTO();
        classroomDTO.setNumber("A1");

        classroomClient.create(classroomDTO);
        Assert.assertNotNull(classroomClient.findById(classroomDTO.getId()));

        classroomDTO.setNumber("A2");
        classroomClient.update(classroomDTO);
        Assert.assertEquals(classroomClient.findById(classroomDTO.getId()).getNumber(), classroomDTO.getNumber());

        classroomClient.removeById(classroomDTO.getId());
        Assert.assertNull(classroomClient.findById(classroomDTO.getId()));
    }

    @Test
    public void findAllClassroom() {
        ClassroomDTO classroomDTO = new ClassroomDTO();
        classroomDTO.setNumber("A1");

        classroomClient.create(classroomDTO);
        Assert.assertNotNull(classroomClient.findById(classroomDTO.getId()));
        Assert.assertFalse(classroomClient.findAll().isEmpty());

        classroomClient.removeById(classroomDTO.getId());
        Assert.assertNull(classroomClient.findById(classroomDTO.getId()));
    }
}
