package com.observation.persistence.repository;

import com.observation.persistence.model.Company;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface RepositoryCompanyPage extends PagingAndSortingRepository<Company, UUID>, RepositoryInterfacePage<Company> {

}