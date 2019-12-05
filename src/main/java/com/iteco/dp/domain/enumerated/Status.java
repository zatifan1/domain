package com.iteco.dp.domain.enumerated;

import org.jetbrains.annotations.NotNull;

public enum Status {
    PLANNED("Запланированно"),
    PASSED("Пройдено");

    @NotNull
    private String name;
    Status(@NotNull final String name) {
        this.name = name;
    }

    @NotNull
    public String displayName() {
        return name;
    }
}
