package com.iteco.dp.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDTO extends AbstractUserDTO {

    private String classroomId;

    private String teacherId;
}
