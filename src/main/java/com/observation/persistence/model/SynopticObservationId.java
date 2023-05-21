package com.observation.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode(callSuper = false)
public class SynopticObservationId implements Serializable {

    private LocalDateTime dateObservation;
    private String ddddddd;
    private String ii;
    private String iii;
}
