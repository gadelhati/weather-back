package com.observation.persistence.payload.response;

import com.observation.persistence.model.State;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public class DTOResponseCity {

    private long id;
    private String name;
    private State state;
}