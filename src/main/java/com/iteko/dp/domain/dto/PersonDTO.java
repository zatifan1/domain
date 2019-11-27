package com.iteko.dp.domain.dto;

import com.iteko.dp.domain.enumeration.Sex;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;

import java.util.Date;

@Getter
@Setter
public class PersonDTO extends AbstractDTO {

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
    private UserDTO user;
}
