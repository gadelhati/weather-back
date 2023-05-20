package br.eti.observation.persistence.payload.request;

import br.eti.observation.persistence.model.Country;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.UUID;

@Getter
public class DTORequestFederativeUnit {

    private UUID id;
    @NotNull(message = "{name.not.null}") @NotBlank(message = "{name.not.blank}")
    private String name;
    @NotNull
    private String initials;
    private Country country;
}