package com.observation.persistence.repository;

import com.observation.persistence.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RepositoryManufacturer extends JpaRepository<Manufacturer, UUID>, RepositoryInterface<Manufacturer> {

}