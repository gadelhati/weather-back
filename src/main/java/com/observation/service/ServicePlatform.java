package com.observation.service;

import com.observation.persistence.MapStruct;
import com.observation.persistence.model.Platform;
import com.observation.persistence.payload.request.DTORequestPlatform;
import com.observation.persistence.payload.response.DTOResponsePlatform;
import com.observation.persistence.repository.RepositoryPlatform;
import com.observation.persistence.repository.RepositoryPlatformPage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service @RequiredArgsConstructor
public class ServicePlatform implements ServiceInterface<DTOResponsePlatform, DTORequestPlatform> {

    private final RepositoryPlatform repositoryPlatform;
    private final RepositoryPlatformPage repositoryPlatformPage;

    public DTOResponsePlatform create(DTORequestPlatform created){
        return MapStruct.MAPPER.toDTO(repositoryPlatform.save(MapStruct.MAPPER.toObject(created)));
    }
    public Page<DTOResponsePlatform> retrieve(Pageable pageable, String key, String value){
        switch (key) {
            case "id": {
                return repositoryPlatformPage.findByIdOrderByIdAsc(pageable, UUID.fromString(value)).map(MapStruct.MAPPER::toDTO);
            }
            case "name": {
                return repositoryPlatformPage.findByNameContainingIgnoreCaseOrderByNameAsc(pageable, value).map(MapStruct.MAPPER::toDTO);
            }
            default: {
                return repositoryPlatformPage.findAll(pageable).map(MapStruct.MAPPER::toDTO);
            }
        }
    }
    public DTOResponsePlatform update(UUID id, DTORequestPlatform updated){
        return MapStruct.MAPPER.toDTO(repositoryPlatform.save(MapStruct.MAPPER.toObject(updated)));
    }
    public DTOResponsePlatform delete(UUID id){
        Platform object = repositoryPlatform.findById(id).orElse(null);
        repositoryPlatform.deleteById(id);
        return MapStruct.MAPPER.toDTO(object);
    }
    public void delete() {
        repositoryPlatform.deleteAll();
    }
    public boolean existsByName(String value) {
        return repositoryPlatform.existsByNameIgnoreCase(value);
    }
    public boolean existsByNameAndIdNot(String value, UUID id) {
        return repositoryPlatform.existsByNameIgnoreCaseAndIdNot(value, id);
    }
    public boolean existsByTelegraphicCallsign(String value) {
        return repositoryPlatform.existsByTelegraphicCallsignIgnoreCase(value);
    }
    public boolean existsByTelegraphicCallsignAndIdNot(String value, UUID id) {
        return repositoryPlatform.existsByTelegraphicCallsignIgnoreCaseAndIdNot(value, id);
    }
}