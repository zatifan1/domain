package com.iteco.dp.domain.dto;

import com.iteco.dp.domain.enumeration.Sex;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
public class PersonDTO extends AbstractDTO {

    @Nullable
    private String firstName;

    @Nullable
    private String lastName;

    @Nullable
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date birthDate;

    @Nullable
    private String email;

    @Nullable
    private String phone;

    @Nullable
    private Sex sex;

    @Nullable
    private UserDTO userDTO;
}
