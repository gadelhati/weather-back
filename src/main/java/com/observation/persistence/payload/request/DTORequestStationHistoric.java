package com.observation.persistence.payload.request;

import com.observation.persistence.model.*;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class DTORequestStationHistoric {

    private UUID id;
    private Double localDepth;
    private LocalDateTime activation;
    private Double latitude;
    private Double longitude;
    private Integer marsdenSquare;
    private Integer marsdenSubSquare_1;
    private Integer wmoSquare;
    private Integer marsdenSubSquare_5;

    private StationCategory stationCategory;
    private Equipment equipment;
    private Surveying surveying;
    private Institution responsible;
    private Country country;
}