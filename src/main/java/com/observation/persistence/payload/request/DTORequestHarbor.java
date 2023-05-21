package com.observation.persistence.payload.request;

import com.observation.exception.annotation.UniqueNameHarbor;
import com.observation.persistence.model.Institution;
import com.observation.persistence.model.Station;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.UUID;

@Getter @UniqueNameHarbor
public class DTORequestHarbor {

    private UUID id;
    @NotNull(message = "{name.not.null}") @NotBlank(message = "{name.not.blank}")
    private String name;

    private Institution institution;
    private Station station;
}
