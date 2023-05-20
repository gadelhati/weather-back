package br.eti.observation.persistence.repository;

import br.eti.observation.persistence.model.Role;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface RepositoryRolePage extends PagingAndSortingRepository<Role, UUID>, RepositoryInterfacePage<Role> {

}