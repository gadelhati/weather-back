package com.observation.service;

import com.observation.persistence.MapStruct;
import com.observation.persistence.model.Harbor;
import com.observation.persistence.payload.request.DTORequestHarbor;
import com.observation.persistence.payload.response.DTOResponseHarbor;
import com.observation.persistence.repository.RepositoryHarbor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service @RequiredArgsConstructor
public class ServiceHarbor implements ServiceInterface<DTOResponseHarbor, DTORequestHarbor> {

    private final RepositoryHarbor repositoryHarbor;

    public DTOResponseHarbor create(DTORequestHarbor created){
        return MapStruct.MAPPER.toDTO(repositoryHarbor.save(MapStruct.MAPPER.toObject(created)));
    }
    public Page<DTOResponseHarbor> retrieve(Pageable pageable, String key, String value){
        switch (key) {
            case "id": {
                return repositoryHarbor.findByIdOrderByIdAsc(pageable, UUID.fromString(value)).map(MapStruct.MAPPER::toDTO);
            }
            case "name": {
                return repositoryHarbor.findByNameContainingIgnoreCaseOrderByNameAsc(pageable, value).map(MapStruct.MAPPER::toDTO);
            }
            default: {
                return repositoryHarbor.findAll(pageable).map(MapStruct.MAPPER::toDTO);
            }
        }
    }
    public DTOResponseHarbor update(UUID id, DTORequestHarbor updated){
        return MapStruct.MAPPER.toDTO(repositoryHarbor.save(MapStruct.MAPPER.toObject(updated)));
    }
    public DTOResponseHarbor delete(UUID id){
        Harbor object = repositoryHarbor.findById(id).orElse(null);
        repositoryHarbor.deleteById(id);
        return MapStruct.MAPPER.toDTO(object);
    }
    public void delete() {
        repositoryHarbor.deleteAll();
    }
    public boolean existsByName(String value) {
        return repositoryHarbor.existsByNameIgnoreCase(value);
    }
    public boolean existsByNameAndIdNot(String value, UUID id) {
        return repositoryHarbor.existsByNameIgnoreCaseAndIdNot(value, id);
    }
}