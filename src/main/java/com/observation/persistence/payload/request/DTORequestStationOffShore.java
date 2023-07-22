package com.observation.persistence.payload.request;

import com.observation.exception.annotation.UniqueTelegraphicCallsignStationOffShore;
import com.observation.persistence.model.Commission;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

@Getter @Builder @UniqueTelegraphicCallsignStationOffShore
public class DTORequestStationOffShore extends DTORequestStation {

    @NotNull(message = "{telegraphic.callsign.off.shore.not.null}") @NotBlank(message = "{telegraphic.callsign.off.shore.not.blank}")
    private String telegraphicCallsign;
    private Commission commission;
}