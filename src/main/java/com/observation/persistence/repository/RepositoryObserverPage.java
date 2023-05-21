package com.observation.persistence.repository;

import com.observation.persistence.model.Observer;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface RepositoryObserverPage extends PagingAndSortingRepository<Observer, UUID>, RepositoryInterfacePage<Observer> {

}