package com.iteko.dp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class Interview extends AbstractEntity {

    @Nullable
    private Teacher teacher;

    @Nullable
    private Candidate candidate;

    @Nullable
    private Date date;

}
