package com.observation.persistence.repository;

import com.observation.persistence.model.SynopticObservationHistoricOnShore;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface RepositorySynopticObservationHistoricPageOnShore extends PagingAndSortingRepository<SynopticObservationHistoricOnShore, UUID> {

}