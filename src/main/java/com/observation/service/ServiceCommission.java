package com.observation.service;

import com.observation.persistence.MapStruct;
import com.observation.persistence.model.Commission;
import com.observation.persistence.payload.request.DTORequestCommission;
import com.observation.persistence.payload.response.DTOResponseCommission;
import com.observation.persistence.repository.RepositoryCommission;
import com.observation.persistence.repository.RepositoryCommissionPage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service @RequiredArgsConstructor
public class ServiceCommission implements ServiceInterface<DTOResponseCommission, DTORequestCommission> {

    private final RepositoryCommission repositoryCommission;
    private final RepositoryCommissionPage repositoryCommissionPage;

    public DTOResponseCommission create(DTORequestCommission created){
        return MapStruct.MAPPER.toDTO(repositoryCommission.save(MapStruct.MAPPER.toObject(created)));
    }
    public Page<DTOResponseCommission> retrieve(Pageable pageable, String key, String value){
        switch (key) {
            case "id": {
                return repositoryCommissionPage.findByIdOrderByIdAsc(pageable, UUID.fromString(value)).map(MapStruct.MAPPER::toDTO);
            }
            case "name": {
                return repositoryCommissionPage.findByNameContainingIgnoreCaseOrderByNameAsc(pageable, value).map(MapStruct.MAPPER::toDTO);
            }
            default: {
                return repositoryCommissionPage.findAll(pageable).map(MapStruct.MAPPER::toDTO);
            }
        }
    }
    public DTOResponseCommission update(UUID id, DTORequestCommission updated){
        return MapStruct.MAPPER.toDTO(repositoryCommission.save(MapStruct.MAPPER.toObject(updated)));
    }
    public DTOResponseCommission delete(UUID id){
        Commission object = repositoryCommission.findById(id).orElse(null);
        repositoryCommission.deleteById(id);
        return MapStruct.MAPPER.toDTO(object);
    }
    public void delete() {
        repositoryCommission.deleteAll();
    }
    public boolean existsByName(String value) {
        return repositoryCommission.existsByNameIgnoreCase(value);
    }
    public boolean existsByNameAndIdNot(String value, UUID id) {
        return repositoryCommission.existsByNameIgnoreCaseAndIdNot(value, id);
    }
}