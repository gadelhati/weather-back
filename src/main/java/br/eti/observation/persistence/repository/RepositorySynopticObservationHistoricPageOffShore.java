package br.eti.observation.persistence.repository;

import br.eti.observation.persistence.model.SynopticObservationHistoricOffShore;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface RepositorySynopticObservationHistoricPageOffShore extends PagingAndSortingRepository<SynopticObservationHistoricOffShore, UUID> {

}