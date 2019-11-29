package com.iteco.dp.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO extends AbstractDTO{

    @Nullable
    private String login;

    @Nullable
    private String password;

}
