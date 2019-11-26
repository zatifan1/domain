package com.iteko.dp.entity;

import com.iteko.dp.enumeration.Sex;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class Person extends AbstractEntity {
    @Nullable
    private String firstName;
    @Nullable
    private String lastName;
    @Nullable
    private Date birthDate;
    @Nullable
    private String email;
    @Nullable
    private String phone;
    @Nullable
    private Sex sex;
    @Nullable
    private User user;
}

