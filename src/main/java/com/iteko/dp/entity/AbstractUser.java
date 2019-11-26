package com.iteko.dp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;

@Getter
@Setter
@NoArgsConstructor
public abstract class AbstractUser extends AbstractEntity {

    @Nullable
    private Person person;

    @Nullable
    private User user;

}

