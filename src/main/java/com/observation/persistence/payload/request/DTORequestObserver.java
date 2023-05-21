package com.observation.persistence.payload.request;

import com.observation.exception.annotation.UniqueObserverNip;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

import java.util.UUID;

@Getter @UniqueObserverNip
public class DTORequestObserver {

    private UUID id;
    @NotNull(message = "{name.not.null}") @NotBlank(message = "{name.not.blank}")
    private String name;
    @Pattern(regexp = "[0-9]{8}", message = "{nip.valid}") @NotNull(message = "{nip.not.null}") @NotBlank(message = "{nip.not.blank}")
    private String nip;
}