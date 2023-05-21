package com.observation.persistence.payload.request;

import com.observation.exception.annotation.UniqueNameRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.UUID;

@Getter @UniqueNameRole
public class DTORequestRole {

    private UUID id;
    @NotNull(message = "{name.not.null}") @NotBlank(message = "{name.not.blank}")
    private String name;
}