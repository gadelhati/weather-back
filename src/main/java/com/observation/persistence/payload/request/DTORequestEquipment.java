package com.observation.persistence.payload.request;

import com.observation.exception.annotation.UniqueNameEquipment;
import com.observation.persistence.model.Manufacturer;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;

import java.util.UUID;

@Getter @UniqueNameEquipment
public class DTORequestEquipment {

    private UUID id;
    @NotNull(message = "{name.not.null}") @NotBlank(message = "{name.not.blank}")
    private String name;
    private Manufacturer manufacturer;
}