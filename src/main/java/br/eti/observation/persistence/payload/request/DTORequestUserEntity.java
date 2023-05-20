package br.eti.observation.persistence.payload.request;

import br.eti.observation.exception.annotation.*;
import br.eti.observation.persistence.model.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.UUID;

@Getter @Setter @UniqueUsername @UniqueEmail
public class DTORequestUserEntity {

    private UUID id;
    @NotNull(message = "{user.name.not.null}") @NotBlank(message = "{user.name.not.blank}") @HasLength
    private String username;
    @NotBlank(message = "{user.email.not.blank}") @Size(max = 50) @Email
    private String email;
    @NotNull(message = "{user.password.not.null}") @NotBlank(message = "{user.password.not.blank}") @HasDigit @HasUpperCase @HasLowerCase @HasLength
    private String password;
    @NotNull(message = "{user.active.not.null}")
    private boolean active;
    private Collection<Role> role;
}