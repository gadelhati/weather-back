package com.observation.persistence.payload.request;

import com.observation.exception.annotation.UniqueNameRole;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.observation.persistence.model.State;
import lombok.Getter;

@Getter @UniqueNameRole
public class DTORequestCity {

    private long id;
    @NotNull(message = "{name.not.null}") @NotBlank(message = "{name.not.blank}")
    private String name;
    private State state;
}