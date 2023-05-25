package com.observation.persistence.payload.response;

import com.observation.persistence.model.Institution;
import com.observation.persistence.model.Station;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter @AllArgsConstructor
public class DTOResponseHarbor {

    private UUID id;
    private String name;
    private Institution institution;

    private Station station;
}