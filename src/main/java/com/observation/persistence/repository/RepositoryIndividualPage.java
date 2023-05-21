package com.observation.persistence.repository;

import com.observation.persistence.model.Individual;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface RepositoryIndividualPage extends PagingAndSortingRepository<Individual, UUID>, RepositoryInterfacePage<Individual> {

}