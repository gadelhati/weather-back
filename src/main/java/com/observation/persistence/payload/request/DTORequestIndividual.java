package com.observation.persistence.payload.request;

import com.observation.exception.annotation.UniqueIndividual;
import com.observation.exception.enumeration.EGender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
//import org.hibernate.validator.constraints.br.CPF;

import java.util.Date;
import java.util.UUID;

@Getter @Builder
public class DTORequestIndividual extends DTORequestPerson {

    private UUID id;
    private String name;
    private Date birthdate;
    private EGender gender;
    @NotNull(message = "{name.not.null}") @NotBlank(message = "{name.not.blank}") /*@CPF*/ @UniqueIndividual
    private String cpf;
}