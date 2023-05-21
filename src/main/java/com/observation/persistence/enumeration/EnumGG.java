package com.observation.persistence.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public enum EnumGG {
    //TMG HOUR MEDIUM GREENWICH
    GG_00("00"),
    GG_03("03"),
    GG_06("06"),
    GG_09("09"),
    GG_12("12"),
    GG_15("15"),
    GG_18("18"),
    GG_21("21");

    private final String GG;
}