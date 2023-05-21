package com.observation.persistence.repository;

import com.observation.persistence.model.StationOffShore;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RepositoryStationOffShorePage extends PagingAndSortingRepository<StationOffShore, UUID> {

}