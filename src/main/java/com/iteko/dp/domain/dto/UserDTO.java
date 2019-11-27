package com.iteko.dp.domain.dto;

import com.iteko.dp.domain.enumeration.RoleType;
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
public class UserDTO extends AbstractDTO{

    @Nullable
    private String login;

    @Nullable
    private String password;

    @NotNull
    private List<RoleType> roles = new ArrayList<>();
}
