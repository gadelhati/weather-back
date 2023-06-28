package com.observation.persistence.payload.response;

import com.observation.exception.annotation.UniqueNameOM;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor @Getter @UniqueNameOM
public class DTOResponseOM {

    private UUID id;
    private String name;
}
