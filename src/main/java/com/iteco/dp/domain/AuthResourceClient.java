package com.iteco.dp.domain;

import com.iteco.dp.domain.client.*;
import feign.Feign;
import feign.Logger;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.slf4j.Slf4jLogger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthResourceClient {

    @Value("${address}")
    String address;

    @Bean
    public ManagerClient getManagerClient() {
        return createClient(ManagerClient.class);
    }

    @Bean
    public UserClient getUserClient() {
        return createClient(UserClient.class);
    }

    @Bean
    public CandidateClient getCandidateClient() {
        return createClient(CandidateClient.class);
    }

    @Bean
    public InterviewClient getInterviewClient() {
        return createClient(InterviewClient.class);
    }

    @Bean
    public TeacherClient getTeacherClient() {
        return createClient(TeacherClient.class);
    }

    @Bean
    public ClassroomClient getClassroomClient() {
        return createClient(ClassroomClient.class);
    }

    @Bean
    public LessonClient getLessonClient() {
        return createClient(LessonClient.class);
    }

    @Bean
    public PersonClient getPersonClient() {
        return createClient(PersonClient.class);
    }

    @Bean
    public CourseClient getCourseClient() {
        return createClient(CourseClient.class);
    }

    @Bean
    public StreamClient getStreamClient() {
        return createClient(StreamClient.class);
    }

    @Bean
    public StudentClient getStudentClient() {
        return createClient(StudentClient.class);
    }

    private <T> T createClient(Class<T> type) {
        return Feign.builder()
                .contract(new SpringMvcContract())
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .logger(new Slf4jLogger(type))
                .logLevel(Logger.Level.FULL)
                .target(type, address);
    }

}
