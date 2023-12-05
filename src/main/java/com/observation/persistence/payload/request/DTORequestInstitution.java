package com.observation.persistence.payload.request;

import com.observation.exception.annotation.UniqueNameInstitution;
import com.observation.persistence.model.Country;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;

import java.util.UUID;

@Getter @UniqueNameInstitution
public class DTORequestInstitution {

    private UUID id;
    @NotNull(message = "{name.not.null}") @NotBlank(message = "{name.not.blank}")
    private String name;
    private Country country;
}