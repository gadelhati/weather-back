package br.eti.observation.persistence.payload.response;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode
public class DTOResponseSynopticObservationId implements Serializable {

    private LocalDateTime dateObservation;
    private String ddddddd;
    private String ii;
    private String iii;
}
