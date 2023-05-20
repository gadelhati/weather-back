package br.eti.observation.persistence.repository;

import br.eti.observation.persistence.model.SynopticObservation;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface RepositorySynopticObservationPage extends PagingAndSortingRepository<SynopticObservation, UUID> {

}