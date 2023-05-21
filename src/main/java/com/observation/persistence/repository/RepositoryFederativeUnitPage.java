package com.observation.persistence.repository;

import com.observation.persistence.model.FederativeUnit;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface RepositoryFederativeUnitPage extends PagingAndSortingRepository<FederativeUnit, UUID>, RepositoryInterfacePage<FederativeUnit> {

}