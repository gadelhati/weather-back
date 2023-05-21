package com.observation.persistence.payload.request;

import com.observation.exception.annotation.UniqueTelegraphicCallsignStationOffShore;
import com.observation.persistence.model.Commission;
import lombok.Builder;
import lombok.Getter;

@Getter @Builder @UniqueTelegraphicCallsignStationOffShore
public class DTORequestStationOffShore extends DTORequestStation {

    private String telegraphicCallsign;
    private Commission commission;
}