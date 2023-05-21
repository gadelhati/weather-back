package com.observation.persistence.repository;

import com.observation.persistence.model.Station;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RepositoryStationPage extends PagingAndSortingRepository<Station, UUID> {

}