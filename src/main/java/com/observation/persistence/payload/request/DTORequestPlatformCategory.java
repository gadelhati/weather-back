package com.observation.persistence.payload.request;

import com.observation.exception.annotation.UniqueNamePlatformCategory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.UUID;

@Getter @UniqueNamePlatformCategory
public class DTORequestPlatformCategory {

    private UUID id;
    @NotNull(message = "{name.not.null}") @NotBlank(message = "{name.not.blank}")
    private String name;
}