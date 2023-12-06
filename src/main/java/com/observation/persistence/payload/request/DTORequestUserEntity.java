package com.observation.persistence.payload.request;

import com.observation.exception.annotation.*;
import com.observation.persistence.model.Role;
import javax.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.UUID;

@Getter @Setter @UniqueNameUser @UniqueEmailUser
public class DTORequestUserEntity {

    private UUID id;
    @NotNull(message = "{user.name.not.null}") @NotBlank(message = "{user.name.not.blank}") @HasLength
    private String username;
    @NotNull(message = "{user.email.not.null}") @NotBlank(message = "{user.email.not.blank}") @Size(max = 50) @Email
    private String email;
    @NotNull(message = "{password.not.null}") @NotBlank(message = "{password.not.blank}") @HasDigit @HasUpperCase @HasLowerCase @HasMore
    private String password;
    @NotNull(message = "{user.active.not.null}")
    private boolean active;
    private Collection<Role> role;
}