package com.observation.persistence.repository;

import com.observation.persistence.model.StationOnShore;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface RepositoryStationOnShorePage extends PagingAndSortingRepository<StationOnShore, UUID>, RepositoryInterfacePage<StationOnShore> {

}