package br.eti.observation.persistence.payload.request;

import br.eti.observation.exception.annotation.UniqueNameStationOnShore;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter @Builder @UniqueNameStationOnShore
public class DTORequestStationOnShore extends DTORequestStation {

    private Double number;
    private String name;
    private Double altitude;
    private Boolean status;
    private LocalDateTime deactivation;
}