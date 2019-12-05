package com.iteco.dp.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public abstract class AbstractDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    private String id = UUID.randomUUID().toString();
}
