package com.observation.persistence.repository;

import com.observation.persistence.model.Manufacturer;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface RepositoryManufacturerPage extends PagingAndSortingRepository<Manufacturer, UUID>, RepositoryInterfacePage<Manufacturer> {

}