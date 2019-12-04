package com.iteco.dp.domain.dto;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.net.URL;

@Getter
@Setter
public class LessonDTO extends AbstractDTO {

    @NotNull
    private String name;

    @Nullable
    private String description;

    @Nullable
    private String sourceUrl;

    @Nullable
    private CourseDTO courseDTO;

}