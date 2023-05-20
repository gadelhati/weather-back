package br.eti.observation.persistence.repository;

import br.eti.observation.persistence.model.SynopticObservationHistoric;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface RepositorySynopticObservationHistoricPage extends PagingAndSortingRepository<SynopticObservationHistoric, UUID> {

}