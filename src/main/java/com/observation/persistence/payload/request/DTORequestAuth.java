package com.observation.persistence.payload.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DTORequestAuth {

    @NotNull(message = "{user.name.not.null}") @NotBlank(message = "{user.name.not.blank}")
    private String username;
    @NotNull(message = "{user.password.not.null}") @NotBlank(message = "{user.password.not.blank}")
    private String password;
}