package com.observation.persistence.repository;

import com.observation.persistence.model.SynopticObservationHistoric;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface RepositorySynopticObservationHistoricPage extends PagingAndSortingRepository<SynopticObservationHistoric, UUID> {

}