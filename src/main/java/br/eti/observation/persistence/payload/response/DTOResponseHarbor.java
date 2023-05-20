package br.eti.observation.persistence.payload.response;

import br.eti.observation.persistence.model.Institution;
import br.eti.observation.persistence.model.Station;
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