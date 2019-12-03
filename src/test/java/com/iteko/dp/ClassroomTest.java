package com.iteko.dp;

import com.iteco.dp.domain.client.ClassroomClient;
import com.iteco.dp.domain.dto.ClassroomDTO;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@Slf4j
@RunWith(JUnit4.class)
public class ClassroomTest {

    @NotNull
    private ClassroomClient classroomClient;

    @Test
    public void createClassroom() {
        ClassroomDTO classroomDTO = new ClassroomDTO();
        classroomDTO.setNumber("A1");
        classroomClient.create(classroomDTO);

        Assert.assertNotNull(classroomClient.findById(classroomDTO.getId()));
        classroomClient.removeById(classroomDTO.getId());
        Assert.assertNull(classroomClient.findById(classroomDTO.getId()));
    }

}
