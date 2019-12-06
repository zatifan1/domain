package com.iteco.dp.domain;

import com.iteco.dp.domain.client.*;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.cloud.openfeign.support.SpringMvcContract;

public class AuthResourceClient {

    public static ManagerClient getManagerInstance(final String baseUrl) {
        return Feign.builder()
                .contract(new SpringMvcContract())
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(ManagerClient.class, baseUrl);
    }

    public static UserClient getUserInstance(final String baseUrl) {
        return Feign.builder()
                .contract(new SpringMvcContract())
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(UserClient.class, baseUrl);
    }

    public static CandidateClient getCandidateInstance(final String baseUrl) {
        return Feign.builder()
                .contract(new SpringMvcContract())
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(CandidateClient.class, baseUrl);
    }

    public static InterviewClient getInterviewInstance(final String baseUrl) {
        return Feign.builder()
                .contract(new SpringMvcContract())
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(InterviewClient.class, baseUrl);
    }

    public static TeacherClient getTeacherInstance(final String baseUrl) {
        return Feign.builder()
                .contract(new SpringMvcContract())
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(TeacherClient.class, baseUrl);
    }

    public static ClassroomClient getClassroomInstance(final String baseUrl) {
        return Feign.builder()
                .contract(new SpringMvcContract())
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(ClassroomClient.class, baseUrl);
    }

    public static LessonClient getLessonInstance(final String baseUrl) {
        return Feign.builder()
                .contract(new SpringMvcContract())
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(LessonClient.class, baseUrl);
    }

    public static PersonClient getPersonInstance(final String baseUrl) {
        return Feign.builder()
                .contract(new SpringMvcContract())
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(PersonClient.class, baseUrl);
    }

    public static CourseClient getCourseInstance(final String baseUrl) {
        return Feign.builder()
                .contract(new SpringMvcContract())
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(CourseClient.class, baseUrl);
    }

    public static StreamClient getStreamInstance(final String baseUrl) {
        return Feign.builder()
                .contract(new SpringMvcContract())
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(StreamClient.class, baseUrl);
    }

    public static StudentClient getStudentInstance(final String baseUrl) {
        return Feign.builder()
                .contract(new SpringMvcContract())
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(StudentClient.class, baseUrl);
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
