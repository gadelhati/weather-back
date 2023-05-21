package com.observation.persistence.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public enum EnumTypeStation {
    SHIP("Ship"),
    SYNOP("Synop");

    private final String type;
}