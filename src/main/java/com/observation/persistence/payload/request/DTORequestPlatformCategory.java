package com.observation.persistence.payload.request;

import com.observation.exception.annotation.UniqueNamePlatformCategory;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;

import java.util.UUID;

@Getter @UniqueNamePlatformCategory
public class DTORequestPlatformCategory {

    private UUID id;
    @NotNull(message = "{name.not.null}") @NotBlank(message = "{name.not.blank}")
    private String name;
}