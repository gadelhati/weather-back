package com.observation.persistence.payload.response;

import com.observation.persistence.model.Harbor;
import com.observation.persistence.model.Institution;
import com.observation.persistence.model.Platform;
import com.observation.persistence.model.Surveying;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;
import java.util.UUID;

@Getter @AllArgsConstructor
public class DTOResponseCommission {

    private UUID id;
    private String name;
    private Date departure;
    private Date arrival;
    private Float latitudeMostBottom;
    private Float latitudeMostTop;
    private Float longitudeMostRight;
    private Float longitudeMostLeft;
    private Harbor origin;
    private Harbor destination;
    private Institution responsible;
    private Institution coordinator;
    private Surveying surveying;
    private Platform platform;
}