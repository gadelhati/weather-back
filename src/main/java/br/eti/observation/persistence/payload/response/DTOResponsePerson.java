package br.eti.observation.persistence.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
@Getter
public class DTOResponsePerson {

    private UUID id;
    private String name;
}