package com.observation.persistence.payload.request;

import com.observation.exception.annotation.UniqueNameManufacturer;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;

import java.util.UUID;

@Getter @UniqueNameManufacturer
public class DTORequestManufacturer {

    private UUID id;
    @NotNull(message = "{name.not.null}") @NotBlank(message = "{name.not.blank}")
    private String name;
}