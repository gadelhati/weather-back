package br.eti.observation.persistence.payload.request;

import br.eti.observation.exception.annotation.UniquePlatformCategory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.UUID;

@Getter @UniquePlatformCategory
public class DTORequestPlatformCategory {

    private UUID id;
    @NotNull(message = "{name.not.null}") @NotBlank(message = "{name.not.blank}")
    private String name;
}