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
    @NotNull(message = "{name.not.null}")
    private Country country;
    @NotNull(message = "{name.not.null}")
    private PlatformCategory platformCategory;
}