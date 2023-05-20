package br.eti.observation.persistence.payload.request;

import br.eti.observation.exception.annotation.UniqueNameCountry;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.UUID;

@Getter @UniqueNameCountry
public class DTORequestCountry {

    private UUID id;
    @NotNull(message = "{name.not.null}") @NotBlank(message = "{name.not.blank}")
    private String name;
}