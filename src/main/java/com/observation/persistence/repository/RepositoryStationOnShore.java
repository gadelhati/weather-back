package com.observation.persistence.repository;

import com.observation.persistence.model.Manufacturer;
import com.observation.persistence.model.StationOnShore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RepositoryStationOnShore extends JpaRepository<StationOnShore, UUID>, RepositoryInterface<StationOnShore> {

}