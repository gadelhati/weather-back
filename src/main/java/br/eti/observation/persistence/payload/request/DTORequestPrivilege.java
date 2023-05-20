package br.eti.observation.persistence.payload.request;

import br.eti.observation.exception.annotation.UniqueNamePrivilege;
import br.eti.observation.persistence.model.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter @UniqueNamePrivilege
public class DTORequestPrivilege {

    private UUID id;
    @NotNull(message = "{privilege.name.not.null}") @NotBlank(message = "{privilege.name.not.blank}")
    private String name;
    private Set<Role> roles = new HashSet<>();
}