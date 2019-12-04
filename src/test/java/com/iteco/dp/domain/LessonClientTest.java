package com.iteco.dp.domain;

import com.iteco.dp.domain.client.LessonClient;
import com.iteco.dp.domain.dto.CourseDTO;
import com.iteco.dp.domain.dto.LessonDTO;
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
import java.util.List;
import java.util.stream.IntStream;

@Slf4j
@RunWith(JUnit4.class)
public class LessonClientTest {

    private LessonClient lessonClient;

    private List<LessonDTO> testLessons = new ArrayList<>();

    @Before
    public void setup() {
        lessonClient = AuthResourceClient.getLessonInstance("http://localhost:8080//api");
    }

    @After
    public void tearDown() {
        testLessons.forEach(e -> lessonClient.delete(e.getId()));
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
        lessonClient.delete(lessonDTO.getId());
        Assert.assertNull(lessonClient.findById(lessonDTO.getId()));
    }

    private LessonDTO getLessonDTO() {
        @NotNull final LessonDTO lessonDTO = new LessonDTO();
        lessonDTO.setName("name");
        lessonDTO.setDescription("description");
        lessonDTO.setSourceUrl("url");
        CourseDTO courseDTO = new CourseDTO();
        lessonDTO.setCourseDTO(courseDTO);
        return lessonDTO;
    }

}
