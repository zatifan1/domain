package com.iteko.dp.dto;

import com.iteko.dp.enumeration.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {

    @Nullable
    private String uuid;

    @Nullable
    private String login;

    @Nullable
    private String password;

    @NotNull
    private List<Role> roles = new ArrayList<>();

}
