package com.iteco.dp.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;

@Setter
@Getter
@NoArgsConstructor
public class CourseDTO extends AbstractDTO {

    @Nullable
    private String name;

    @Nullable
    private String description;
}
