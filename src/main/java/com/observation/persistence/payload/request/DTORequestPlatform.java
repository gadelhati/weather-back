package com.observation.persistence.payload.request;

import com.observation.exception.annotation.UniqueTelegraphicCallsignPlatform;
import com.observation.persistence.model.Country;
import com.observation.persistence.model.PlatformCategory;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter @UniqueTelegraphicCallsignPlatform
public class DTORequestPlatform {

    private UUID id;
    private String visualCallsign;
    private String telegraphicCallsign;
    private String internationalCallsign;
    private String name;
    private String internationalName;
    private Country country;
    private PlatformCategory platformCategory;
}