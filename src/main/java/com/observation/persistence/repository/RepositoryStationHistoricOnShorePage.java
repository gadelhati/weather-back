package com.observation.persistence.repository;

import com.observation.persistence.model.StationHistoricOnShore;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface RepositoryStationHistoricOnShorePage extends PagingAndSortingRepository<StationHistoricOnShore, UUID>, RepositoryInterfacePage<StationHistoricOnShore> {

}