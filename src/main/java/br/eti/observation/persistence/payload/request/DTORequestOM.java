package br.eti.observation.persistence.payload.request;

import br.eti.observation.exception.annotation.UniqueOM;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.UUID;

@Getter
public class DTORequestOM {

    private UUID id;
    @NotNull(message = "{name.not.null}") @NotBlank(message = "{name.not.blank}")  @UniqueOM
    private String name;
}