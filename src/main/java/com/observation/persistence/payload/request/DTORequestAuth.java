package com.observation.persistence.payload.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DTORequestAuth {

    @NotNull(message = "{auth.username.not.null}") @NotBlank(message = "{auth.username.not.blank}")
    private String username;
    @NotNull(message = "{auth.password.not.null}") @NotBlank(message = "{auth.password.not.blank}")
    private String password;
}