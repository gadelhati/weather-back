package com.observation.persistence.payload.response;

import com.observation.persistence.model.Country;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public class DTOResponseState {

    private long id;
    private String name;
    private Country country;
}