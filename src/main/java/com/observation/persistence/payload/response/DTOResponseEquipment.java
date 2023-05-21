package com.observation.persistence.payload.response;

import com.observation.persistence.model.Manufacturer;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter @AllArgsConstructor
public class DTOResponseEquipment {

    private UUID id;
    private String name;
    private Manufacturer manufacturer;
}