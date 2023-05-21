package com.observation.persistence.repository;

import com.observation.persistence.model.StationHistoric;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RepositoryStationHistoricPage extends PagingAndSortingRepository<StationHistoric, UUID> {

}