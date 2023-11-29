package com.observation.persistence.payload.request;

import com.observation.persistence.model.Harbor;
import com.observation.persistence.model.Institution;
import com.observation.persistence.model.Platform;
import com.observation.persistence.model.Surveying;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;

import java.util.Date;
import java.util.UUID;

@Getter
public class DTORequestCommission {

    private UUID id;
    @NotNull(message = "{name.not.null}") @NotBlank(message = "{name.not.blank}")
    private String name;
    private Date departure;
    private Date arrival;
    private Float latitudeMostBottom;
    private Float latitudeMostTop;
    private Float longitudeMostRight;
    private Float longitudeMostLeft;
    @NotNull(message = "{name.not.null}")
    private Harbor origin;
    @NotNull(message = "{name.not.null}")
    private Harbor destination;
    @NotNull(message = "{name.not.null}")
    private Institution responsible;
    @NotNull(message = "{name.not.null}")
    private Institution coordinator;
    @NotNull(message = "{name.not.null}")
    private Surveying surveying;
    @NotNull(message = "{name.not.null}")
    private Platform platform;
}