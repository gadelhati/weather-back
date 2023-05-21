package com.observation.persistence.repository;

import com.observation.persistence.model.SynopticObservationHistoricOffShore;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface RepositorySynopticObservationHistoricPageOffShore extends PagingAndSortingRepository<SynopticObservationHistoricOffShore, UUID> {

}