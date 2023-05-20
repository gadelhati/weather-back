package br.eti.observation.persistence.payload.response;

import br.eti.observation.persistence.model.Country;
import br.eti.observation.persistence.model.PlatformCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter @AllArgsConstructor
public class DTOResponsePlatform {

    private UUID id;
    private String visualCallsign;
    private String telegraphicCallsign;
    private String internationalCallsign;
    private String name;
    private String internationalName;
    private Country country;
    private PlatformCategory platformCategory;
}