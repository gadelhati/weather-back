package br.eti.observation.persistence.repository;

import br.eti.observation.persistence.model.Privilege;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface RepositoryPrivilegePage extends PagingAndSortingRepository<Privilege, UUID>, RepositoryInterfacePage<Privilege> {

}