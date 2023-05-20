package br.eti.observation.persistence.payload.request;

import lombok.Getter;

import java.util.Date;
import java.util.UUID;

@Getter
public class DTORequestPerson {

    private UUID id;
    private String name;
    private Date birthdate;
}