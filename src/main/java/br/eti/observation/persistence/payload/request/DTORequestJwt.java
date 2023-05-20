package br.eti.observation.persistence.payload.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DTORequestJwt {

    @NotNull(message = "{name.not.null}") @NotBlank(message = "{name.not.blank}")
    private String username;
    @NotNull(message = "{password.not.null}") @NotBlank(message = "{password.not.blank}")
    private String password;
}