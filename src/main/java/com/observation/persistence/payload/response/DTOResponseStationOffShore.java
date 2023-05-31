package com.observation.persistence.payload.response;

import com.observation.persistence.model.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter @Builder @AllArgsConstructor
public class DTOResponseStationOffShore /*extends DTOResponseStation*/ {

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
    private Institution institution;
    private Country country;

    private String telegraphicCallsign;
    private Commission commission;
}