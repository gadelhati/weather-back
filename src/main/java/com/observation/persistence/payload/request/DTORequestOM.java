package com.observation.persistence.payload.request;

import com.observation.exception.annotation.UniqueNameOM;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.UUID;

@Getter
public class DTORequestOM {

    private UUID id;
    @NotNull(message = "{name.not.null}") @NotBlank(message = "{name.not.blank}")  @UniqueNameOM
    private String name;
}