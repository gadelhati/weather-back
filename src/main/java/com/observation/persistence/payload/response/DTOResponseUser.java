package com.observation.persistence.payload.response;

import com.observation.exception.annotation.auth.UniqueEmail;
import com.observation.exception.annotation.auth.UniqueNameRole;
import com.observation.persistence.model.OM;
import com.observation.persistence.model.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Collection;
import java.util.UUID;

@Getter @AllArgsConstructor @UniqueNameRole
public class DTOResponseUser {

    private UUID id;
    @NotBlank @Size(min = 3, max = 20)
    private String username;
    @NotBlank @Size(max = 50) @Email @UniqueEmail
    private String email;
    private String password;
    private Boolean active;
    private OM om;
    private Collection<Role> roles;
}