package com.observation.persistence.payload.request;

import com.observation.exception.annotation.UniqueEmailResearcher;
import com.observation.exception.annotation.UniqueNameResearcher;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;

import java.util.UUID;

@Getter @UniqueNameResearcher
@UniqueEmailResearcher
public class DTORequestResearcher {

    private UUID id;
    @NotNull(message = "{name.not.null}") @NotBlank(message = "{name.not.blank}")
    private String name;
    @NotNull(message = "{email.not.null}") @NotBlank(message = "{email.not.blank}") @Email
    private String email;
    private String address;
}