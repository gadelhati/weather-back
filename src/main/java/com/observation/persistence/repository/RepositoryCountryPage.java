package com.observation.persistence.repository;

import com.observation.persistence.model.Country;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface RepositoryCountryPage extends PagingAndSortingRepository<Country, UUID>, RepositoryInterfacePage<Country> {

}