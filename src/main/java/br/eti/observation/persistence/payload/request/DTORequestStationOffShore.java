package br.eti.observation.persistence.payload.request;

import br.eti.observation.exception.annotation.UniqueTelegraphicCallsignStationOffShore;
import br.eti.observation.persistence.model.Commission;
import lombok.Builder;
import lombok.Getter;

@Getter @Builder @UniqueTelegraphicCallsignStationOffShore
public class DTORequestStationOffShore extends DTORequestStation {

    private String telegraphicCallsign;
    private Commission commission;
}