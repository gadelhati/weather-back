package br.eti.observation.persistence.payload.request;

import br.eti.observation.exception.annotation.UniqueTelegraphicCallsignPlatform;
import br.eti.observation.persistence.model.Country;
import br.eti.observation.persistence.model.PlatformCategory;
import lombok.Getter;

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