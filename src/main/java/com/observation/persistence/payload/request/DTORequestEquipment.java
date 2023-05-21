package com.observation.persistence.payload.request;

import com.observation.exception.annotation.UniqueNameEquipment;
import com.observation.persistence.model.Manufacturer;
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