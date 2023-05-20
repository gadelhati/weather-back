package br.eti.observation.persistence.payload.request;

import br.eti.observation.exception.annotation.UniqueNameEquipment;
import br.eti.observation.persistence.model.Manufacturer;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.UUID;

@Getter @UniqueNameEquipment
public class DTORequestEquipment {

    private UUID id;
    @NotNull(message = "{name.not.null}") @NotBlank(message = "{name.not.blank}")
    private String name;
    private Manufacturer manufacturer;
}