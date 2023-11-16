package com.observation.service;

import com.observation.persistence.MapStruct;
import com.observation.persistence.payload.request.DTORequestRole;
import com.observation.persistence.payload.response.DTOResponseRole;
import com.observation.persistence.repository.RepositoryRole;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service @RequiredArgsConstructor
public class ServiceRole implements ServiceInterface<DTOResponseRole, DTORequestRole> {

    private final RepositoryRole repositoryRole;

    public DTOResponseRole create(DTORequestRole created){
        return MapStruct.MAPPER.toDTO(repositoryRole.save(MapStruct.MAPPER.toObject(created)));
    }
    public Page<DTOResponseRole> retrieve(Pageable pageable, String key, String value) {
        switch (key) {
            case "id": {
                return repositoryRole.findByIdOrderByIdAsc(pageable, UUID.fromString(value)).map(MapStruct.MAPPER::toDTO);
            }
            case "name": {
                return repositoryRole.findByNameContainingIgnoreCaseOrderByNameAsc(pageable, value).map(MapStruct.MAPPER::toDTO);
            }
            default: {
                return repositoryRole.findAll(pageable).map(MapStruct.MAPPER::toDTO);
            }
        }
    }
    public DTOResponseRole update(UUID id, DTORequestRole updated){
        return MapStruct.MAPPER.toDTO(repositoryRole.save(MapStruct.MAPPER.toObject(updated)));
    }
    public DTOResponseRole delete(UUID id){
        DTOResponseRole dtoResponseRole = MapStruct.MAPPER.toDTO(repositoryRole.findById(id).orElse(null));
        repositoryRole.deleteById(id);
        return dtoResponseRole;
    }
    public void delete() {
        repositoryRole.deleteAll();
    }

    public boolean existsByName(String value) {
        return repositoryRole.existsByNameIgnoreCase(value);
    }
    public boolean existsByNameAndIdNot(String value, UUID id) {
        return repositoryRole.existsByNameIgnoreCaseAndIdNot(value, id);
    }
}