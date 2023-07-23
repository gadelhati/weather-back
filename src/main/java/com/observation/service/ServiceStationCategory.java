package com.observation.service;

import com.observation.persistence.MapStruct;
import com.observation.persistence.model.StationCategory;
import com.observation.persistence.payload.request.DTORequestStationCategory;
import com.observation.persistence.payload.response.DTOResponseStationCategory;
import com.observation.persistence.repository.RepositoryStationCategory;
import com.observation.persistence.repository.RepositoryStationCategoryPage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service @RequiredArgsConstructor
public class ServiceStationCategory implements ServiceInterface<DTOResponseStationCategory, DTORequestStationCategory> {

    private final RepositoryStationCategory repositoryStationCategory;
    private final RepositoryStationCategoryPage repositoryStationCategoryPage;

    public DTOResponseStationCategory create(DTORequestStationCategory created){
        return MapStruct.MAPPER.toDTO(repositoryStationCategory.save(MapStruct.MAPPER.toObject(created)));
    }
    public Page<DTOResponseStationCategory> retrieve(Pageable pageable, String key, String value){
        switch (key) {
            case "id": {
                return repositoryStationCategoryPage.findByIdOrderByIdAsc(pageable, UUID.fromString(value)).map(MapStruct.MAPPER::toDTO);
            }
            case "name": {
                return repositoryStationCategoryPage.findByNameContainingIgnoreCaseOrderByNameAsc(pageable, value).map(MapStruct.MAPPER::toDTO);
            }
            default: {
                return repositoryStationCategoryPage.findAll(pageable).map(MapStruct.MAPPER::toDTO);
            }
        }
    }
    public DTOResponseStationCategory update(UUID id, DTORequestStationCategory updated){
        return MapStruct.MAPPER.toDTO(repositoryStationCategory.save(MapStruct.MAPPER.toObject(updated)));
    }
    public DTOResponseStationCategory delete(UUID id){
        StationCategory object = repositoryStationCategory.findById(id).orElse(null);
        repositoryStationCategory.deleteById(id);
        return MapStruct.MAPPER.toDTO(object);
    }
    public void delete() {
        repositoryStationCategory.deleteAll();
    }
    public boolean existsByName(String value) {
        return repositoryStationCategory.existsByNameIgnoreCase(value);
    }
    public boolean existsByNameAndIdNot(String value, UUID id) {
        return repositoryStationCategory.existsByNameIgnoreCaseAndIdNot(value, id);
    }
}