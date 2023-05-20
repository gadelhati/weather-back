package br.eti.observation.persistence.payload.request;

import br.eti.observation.exception.annotation.UniqueNameStationCategory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.UUID;

@Getter @UniqueNameStationCategory
public class DTORequestStationCategory {

    private UUID id;
    @NotNull(message = "{name.not.null}") @NotBlank(message = "{name.not.blank}")
    private String name;
}