package com.observation.persistence.payload.request;

import com.observation.exception.annotation.UniqueInstitution;
import com.observation.persistence.model.Country;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.UUID;

@Getter @UniqueInstitution
public class DTORequestInstitution {

    private UUID id;
    @NotNull(message = "{name.not.null}") @NotBlank(message = "{name.not.blank}")
    private String name;
    private Country country;
}