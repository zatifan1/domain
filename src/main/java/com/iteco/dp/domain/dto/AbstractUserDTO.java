package com.iteco.dp.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;

@Getter
@Setter
@NoArgsConstructor
public class AbstractUserDTO extends AbstractDTO {

    @Nullable
    private String personId;
}
