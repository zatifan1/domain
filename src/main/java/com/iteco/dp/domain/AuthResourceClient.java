package com.iteco.dp.domain;

import com.iteco.dp.domain.client.*;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
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
        return Feign.builder()
                .contract(new SpringMvcContract())
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(ManagerClient.class, address);
    }

    @Bean
    public UserClient getUserClient() {
        return Feign.builder()
                .contract(new SpringMvcContract())
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(UserClient.class, address);
    }

    @Bean
    public CandidateClient getCandidateClient() {
        return Feign.builder()
                .contract(new SpringMvcContract())
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(CandidateClient.class, address);
    }

    @Bean
    public InterviewClient getInterviewClient() {
        return Feign.builder()
                .contract(new SpringMvcContract())
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(InterviewClient.class, address);
    }

    @Bean
    public TeacherClient getTeacherClient() {
        return Feign.builder()
                .contract(new SpringMvcContract())
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(TeacherClient.class, address);
    }

    @Bean
    public ClassroomClient getClassroomClient() {
        return Feign.builder()
                .contract(new SpringMvcContract())
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(ClassroomClient.class, address);
    }

    @Bean
    public LessonClient getLessonClient() {
        return Feign.builder()
                .contract(new SpringMvcContract())
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(LessonClient.class, address);
    }

    @Bean
    public PersonClient getPersonClient() {
        return Feign.builder()
                .contract(new SpringMvcContract())
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(PersonClient.class, address);
    }

    @Bean
    public CourseClient getCourseClient() {
        return Feign.builder()
                .contract(new SpringMvcContract())
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(CourseClient.class, address);
    }

    @Bean
    public StreamClient getStreamClient() {
        return Feign.builder()
                .contract(new SpringMvcContract())
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(StreamClient.class, address);
    }

    @Bean
    public StudentClient getStudentClient() {
        return Feign.builder()
                .contract(new SpringMvcContract())
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(StudentClient.class, address);
    }

//    public static <T> T createClient(Class<T> type, String uri) {
//        return Feign.builder()
//                .contract(new SpringMvcContract())
//                .encoder(new JacksonEncoder())
//                .decoder(new JacksonDecoder())
//                .logger(new Slf4jLogger(type))
//                .logLevel(Logger.Level.FULL)
//                .target(type, uri);
//    }

}
