package com.iteco.dp.domain.dto;

import com.iteco.dp.domain.enumerated.Status;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;

import java.util.Date;

@Getter
@Setter
public class InterviewDTO extends AbstractDTO {

    @Nullable
    private String teacherId;

    @Nullable
    private String candidateId;

    @Nullable
    private Date dateOfInterview;

    @Nullable
    private Status status;

    @Nullable
    private String courseId;

    private int interviewGrade;
}
