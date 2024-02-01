package com.observation.persistence.payload.request;

import com.observation.exception.annotation.UniqueNameRole;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.observation.persistence.model.Country;
import lombok.Getter;

@Getter @UniqueNameRole
public class DTORequestState {

    private long id;
    @NotNull(message = "{name.not.null}") @NotBlank(message = "{name.not.blank}")
    private String name;
    private Country country;
}