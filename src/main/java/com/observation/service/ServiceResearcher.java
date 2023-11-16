package com.observation.service;

import com.observation.persistence.MapStruct;
import com.observation.persistence.model.Researcher;
import com.observation.persistence.payload.request.DTORequestResearcher;
import com.observation.persistence.payload.response.DTOResponseResearcher;
import com.observation.persistence.repository.RepositoryResearcher;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service @RequiredArgsConstructor
public class ServiceResearcher implements ServiceInterface<DTOResponseResearcher, DTORequestResearcher> {

    private final RepositoryResearcher repositoryResearcher;

    public DTOResponseResearcher create(DTORequestResearcher created){
        return MapStruct.MAPPER.toDTO(repositoryResearcher.save(MapStruct.MAPPER.toObject(created)));
    }
    public Page<DTOResponseResearcher> retrieve(Pageable pageable, String key, String value){
        switch (key) {
            case "id": {
                return repositoryResearcher.findByIdOrderByIdAsc(pageable, UUID.fromString(value)).map(MapStruct.MAPPER::toDTO);
            }
            case "name": {
                return repositoryResearcher.findByNameContainingIgnoreCaseOrderByNameAsc(pageable, value).map(MapStruct.MAPPER::toDTO);
            }
            default: {
                return repositoryResearcher.findAll(pageable).map(MapStruct.MAPPER::toDTO);
            }
        }
    }
    public DTOResponseResearcher update(UUID id, DTORequestResearcher updated){
        return MapStruct.MAPPER.toDTO(repositoryResearcher.save(MapStruct.MAPPER.toObject(updated)));
    }
    public DTOResponseResearcher delete(UUID id){
        Researcher object = repositoryResearcher.findById(id).orElse(null);
        repositoryResearcher.deleteById(id);
        return MapStruct.MAPPER.toDTO(object);
    }
    public void delete() {
        repositoryResearcher.deleteAll();
    }
    public boolean existsByName(String value) {
        return repositoryResearcher.existsByNameIgnoreCase(value);
    }
    public boolean existsByNameAndIdNot(String value, UUID id) {
        return repositoryResearcher.existsByNameIgnoreCaseAndIdNot(value, id);
    }
}