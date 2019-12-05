package com.iteco.dp.domain;

import com.iteco.dp.domain.client.*;
import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import org.springframework.cloud.openfeign.support.SpringMvcContract;

public class AuthResourceClient {

    public static ManagerClient getManagerInstance(final String baseUrl) {
        return Feign.builder()
                .contract(new SpringMvcContract())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .target(ManagerClient.class, baseUrl);
    }

    public static UserClient getUserInstance(final String baseUrl) {
        return Feign.builder()
                .contract(new SpringMvcContract())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .target(UserClient.class, baseUrl);
    }

    public static CandidateClient getCandidateInstance(final String baseUrl) {
        return Feign.builder()
                .contract(new SpringMvcContract())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .target(CandidateClient.class, baseUrl);
    }

    public static InterviewClient getInterviewInstance(final String baseUrl) {
        return Feign.builder()
                .contract(new SpringMvcContract())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .target(InterviewClient.class, baseUrl);
    }

    public static TeacherClient getTeacherInstance(final String baseUrl) {
        return Feign.builder()
                .contract(new SpringMvcContract())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .target(TeacherClient.class, baseUrl);
    }

    public static ClassroomClient getClassroomInstance(final String baseUrl) {
        return Feign.builder()
                .contract(new SpringMvcContract())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .target(ClassroomClient.class, baseUrl);
    }

    public static LessonClient getLessonInstance(final String baseUrl) {
        return Feign.builder()
                .contract(new SpringMvcContract())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .target(LessonClient.class, baseUrl);
    }

    public static PersonClient getPersonInstance(final String baseUrl) {
        return Feign.builder()
                .contract(new SpringMvcContract())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .target(PersonClient.class, baseUrl);
    }

    public static CourseClient getCourseInstance(final String baseUrl) {
        return Feign.builder()
                .contract(new SpringMvcContract())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .target(CourseClient.class, baseUrl);
    }

    public static StreamClient getStreamInstance(final String baseUrl) {
        return Feign.builder()
                .contract(new SpringMvcContract())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .target(StreamClient.class, baseUrl);
    }
}
