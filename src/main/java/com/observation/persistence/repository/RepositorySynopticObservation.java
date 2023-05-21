package com.observation.persistence.repository;

import com.observation.persistence.model.SynopticObservation;
import com.observation.persistence.model.SynopticObservationId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorySynopticObservation extends JpaRepository<SynopticObservation, SynopticObservationId> {

}