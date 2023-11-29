package com.observation.persistence.payload.request;

import com.observation.exception.annotation.UniqueTelegraphicCallsignStationOffShore;
import com.observation.persistence.model.Commission;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter @Builder @UniqueTelegraphicCallsignStationOffShore
public class DTORequestStationHistoricOffShore extends DTORequestStation {

    private String telegraphicCallsign;
    @NotNull(message = "{name.not.null}")
    private Commission commission;
}