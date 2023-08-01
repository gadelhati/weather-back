package com.observation.persistence.payload.request;

import com.observation.persistence.model.Country;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;

import java.util.UUID;

@Getter
public class DTORequestFederativeUnit {

    private UUID id;
    @NotNull(message = "{name.not.null}") @NotBlank(message = "{name.not.blank}")
    private String name;
    @NotNull
    private String initials;
    private Country country;
}