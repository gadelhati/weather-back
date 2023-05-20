package br.eti.observation.persistence.payload.request;

import br.eti.observation.persistence.model.Harbor;
import br.eti.observation.persistence.model.Institution;
import br.eti.observation.persistence.model.Platform;
import br.eti.observation.persistence.model.Surveying;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.Date;
import java.util.UUID;

@Getter
public class DTORequestCommission {

    private UUID id;
    @NotNull(message = "{name.not.null}") @NotBlank(message = "{name.not.blank}")
    private String name;
    private Date departure;
    private Date arrival;
    private Float latitudeMostBottom;
    private Float latitudeMostTop;
    private Float longitudeMostRight;
    private Float longitudeMostLeft;
    private Harbor origin;
    private Harbor destination;
    private Institution responsible;
    private Institution coordinator;
    private Surveying surveying;
    private Platform platform;
}