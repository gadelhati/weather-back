package com.observation.persistence.repository;

import com.observation.persistence.model.Harbor;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface RepositoryHarborPage extends PagingAndSortingRepository<Harbor, UUID>, RepositoryInterfacePage<Harbor> {

}