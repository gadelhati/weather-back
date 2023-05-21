package com.observation.persistence.repository;

import com.observation.persistence.model.StationCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RepositoryStationCategory extends JpaRepository<StationCategory, UUID>, RepositoryInterface<StationCategory> {

}