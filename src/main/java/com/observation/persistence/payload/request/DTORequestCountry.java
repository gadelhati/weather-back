package com.observation.persistence.payload.request;

import com.observation.exception.annotation.UniqueNameCountry;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;

import java.util.UUID;

@Getter @UniqueNameCountry
public class DTORequestCountry {

    private UUID id;
    @NotNull(message = "{name.not.null}") @NotBlank(message = "{name.not.blank}")
    private String name;
}