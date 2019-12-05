package com.iteco.dp.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class StreamDTO extends AbstractDTO {

    @Nullable
    private String courseId;

    @Nullable
    private Date startDate;

    @Nullable
    private Date finishDate;
}
