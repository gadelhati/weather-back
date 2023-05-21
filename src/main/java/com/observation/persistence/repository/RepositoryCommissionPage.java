package com.observation.persistence.repository;

import com.observation.persistence.model.Commission;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface RepositoryCommissionPage extends PagingAndSortingRepository<Commission, UUID>, RepositoryInterfacePage<Commission> {

}