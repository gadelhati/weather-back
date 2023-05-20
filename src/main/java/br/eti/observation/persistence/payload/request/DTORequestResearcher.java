package br.eti.observation.persistence.payload.request;

import br.eti.observation.exception.annotation.UniqueEmailResearcher;
import br.eti.observation.exception.annotation.UniqueNameResearcher;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.UUID;

@Getter @UniqueNameResearcher @UniqueEmailResearcher
public class DTORequestResearcher {

    private UUID id;
    @NotNull(message = "{name.not.null}") @NotBlank(message = "{name.not.blank}")
    private String name;
    @NotNull(message = "{email.not.null}") @NotBlank(message = "{email.not.blank}") @Email
    private String email;
    private String address;
}