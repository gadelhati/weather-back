package com.observation.persistence.payload.request;

import com.observation.exception.annotation.UniqueNameIndividual;
import com.observation.persistence.enumeration.EGender;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;
import java.util.UUID;

@Getter @Builder
public class DTORequestIndividual extends DTORequestPerson {

    private UUID id;
    private String name;
    private Date birthdate;
    private EGender gender;
    @NotNull(message = "{name.not.null}") @NotBlank(message = "{name.not.blank}") @UniqueNameIndividual
    private String cpf;
}