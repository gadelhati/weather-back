package com.observation.persistence.payload.request;

import com.observation.persistence.model.*;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class DTORequestStation {

    private UUID id;
    private Double localDepth;
    private LocalDateTime activation;
    private Double latitude;
    private Double longitude;
    private Integer marsdenSquare;
    private Integer marsdenSubSquare_1;
    private Integer wmoSquare;
    private Integer marsdenSubSquare_5;

    @NotNull(message = "{name.not.null}")
    private StationCategory stationCategory;
    @NotNull(message = "{name.not.null}")
    private Equipment equipment;
    @NotNull(message = "{name.not.null}")
    private Surveying surveying;
    @NotNull(message = "{name.not.null}")
    private Institution institution;
    @NotNull(message = "{name.not.null}")
    private Country country;
}