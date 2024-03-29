package com.iteco.dp.domain.enumerated;

import org.jetbrains.annotations.NotNull;

public enum Sex {
    MALE("Мужчина"),
    FEMALE("Женщина");

    @NotNull
    private String name;

    Sex(@NotNull final String name) {
        this.name = name;
    }

    @NotNull
    public String displayName() {
        return name;
    }
}

