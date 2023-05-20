package br.eti.observation.persistence.payload.request;

import br.eti.observation.exception.annotation.UniqueEmailUser;
import br.eti.observation.exception.annotation.auth.*;
import br.eti.observation.persistence.model.OM;
import br.eti.observation.persistence.model.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.UUID;

@Getter @Setter @UniqueEmailUser @UniqueUsername
public class DTORequestUser {

    private UUID id;
    @NotNull(message = "{name.not.null}") @NotBlank(message = "{name.not.blank}") @ValidUserName
    @UserNameLength
    private String username;
    @NotBlank(message = "{email.not.blank}") @Size(max = 50) @Email
    private String email;
    @NotNull(message = "{password.not.null}") @NotBlank(message = "{password.not.blank}") @PasswordHasDigit
    @PasswordHasLetter
    @PasswordLength
    private String password;
    @NotNull(message = "{active.not.null}")
    private boolean active;
    private OM om;
    private Collection<Role> roles;
}