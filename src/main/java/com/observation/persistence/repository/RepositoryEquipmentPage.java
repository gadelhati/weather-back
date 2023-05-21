package com.observation.persistence.repository;

import com.observation.persistence.model.Equipment;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface RepositoryEquipmentPage extends PagingAndSortingRepository<Equipment, UUID>, RepositoryInterfacePage<Equipment> {

}