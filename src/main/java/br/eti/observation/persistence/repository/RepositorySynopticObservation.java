package br.eti.observation.persistence.repository;

import br.eti.observation.persistence.model.SynopticObservation;
import br.eti.observation.persistence.model.SynopticObservationId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorySynopticObservation extends JpaRepository<SynopticObservation, SynopticObservationId> {

}