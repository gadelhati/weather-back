package com.observation.service;

import com.observation.persistence.MapStruct;
import com.observation.persistence.model.PlatformCategory;
import com.observation.persistence.payload.request.DTORequestPlatformCategory;
import com.observation.persistence.payload.response.DTOResponsePlatformCategory;
import com.observation.persistence.repository.RepositoryPlatformCategory;
import com.observation.persistence.repository.RepositoryPlatformCategoryPage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service @RequiredArgsConstructor
public class ServicePlatformCategory implements ServiceInterface<DTOResponsePlatformCategory, DTORequestPlatformCategory> {

    private final RepositoryPlatformCategory repositoryPlatformCategory;
    private final RepositoryPlatformCategoryPage repositoryPlatformCategoryPage;

    public DTOResponsePlatformCategory create(DTORequestPlatformCategory created){
        return MapStruct.MAPPER.toDTO(repositoryPlatformCategory.save(MapStruct.MAPPER.toObject(created)));
    }
    public Page<DTOResponsePlatformCategory> retrieve(Pageable pageable, String filter){
        switch (pageable.getSort().toString().substring(0, pageable.getSort().toString().length() - 5)) {
            case "id": {
                return repositoryPlatformCategoryPage.findByIdOrderByIdAsc(pageable, UUID.fromString(filter)).map(MapStruct.MAPPER::toDTO);
            }
            default: {
                return repositoryPlatformCategoryPage.findAll(pageable).map(MapStruct.MAPPER::toDTO);
            }
        }
    }
    public DTOResponsePlatformCategory update(UUID id, DTORequestPlatformCategory updated){
        return MapStruct.MAPPER.toDTO(repositoryPlatformCategory.save(MapStruct.MAPPER.toObject(updated)));
    }
    public DTOResponsePlatformCategory delete(UUID id){
        PlatformCategory object = repositoryPlatformCategory.findById(id).orElse(null);
        repositoryPlatformCategory.deleteById(id);
        return MapStruct.MAPPER.toDTO(object);
    }
    public void delete() {
        repositoryPlatformCategory.deleteAll();
    }
    public boolean existsByName(String value) {
        return repositoryPlatformCategory.existsByNameIgnoreCase(value);
    }
    public boolean existsByNameAndIdNot(String value, UUID id) {
        return repositoryPlatformCategory.existsByNameIgnoreCaseAndIdNot(value, id);
    }
}