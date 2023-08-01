package com.observation.persistence.payload.request;

import com.observation.exception.annotation.UniqueNIPObserver;
import com.observation.exception.annotation.UniqueNameObserver;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.Getter;

import java.util.UUID;

@Getter @UniqueNIPObserver @UniqueNameObserver
public class DTORequestObserver {

    private UUID id;
    @NotNull(message = "{name.not.null}") @NotBlank(message = "{name.not.blank}")
    private String name;
    @Pattern(regexp = "[0-9]{8}", message = "{nip.valid}") @NotNull(message = "{nip.not.null}") @NotBlank(message = "{nip.not.blank}")
    private String nip;
}