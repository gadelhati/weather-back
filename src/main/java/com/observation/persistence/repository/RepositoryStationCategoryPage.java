package com.observation.persistence.repository;

import com.observation.persistence.model.StationCategory;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface RepositoryStationCategoryPage extends PagingAndSortingRepository<StationCategory, UUID>, RepositoryInterfacePage<StationCategory> {

}