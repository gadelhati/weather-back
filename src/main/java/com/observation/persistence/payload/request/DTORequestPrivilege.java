package com.observation.persistence.payload.request;

import com.observation.exception.annotation.UniqueNamePrivilege;
import com.observation.persistence.model.Role;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter @UniqueNamePrivilege
public class DTORequestPrivilege {

    private UUID id;
    @NotNull(message = "{name.not.null}") @NotBlank(message = "{name.not.blank}")
    private String name;
    private Set<Role> roles = new HashSet<>();
}