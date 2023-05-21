package com.observation.service;

import com.observation.persistence.MapStruct;
import com.observation.persistence.model.Manufacturer;
import com.observation.persistence.payload.request.DTORequestManufacturer;
import com.observation.persistence.payload.response.DTOResponseManufacturer;
import com.observation.persistence.repository.RepositoryManufacturer;
import com.observation.persistence.repository.RepositoryManufacturerPage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service @RequiredArgsConstructor
public class ServiceManufacturer implements ServiceInterface<DTOResponseManufacturer, DTORequestManufacturer> {

    private final RepositoryManufacturer repositoryManufacturer;
    private final RepositoryManufacturerPage repositoryManufacturerPage;

    public DTOResponseManufacturer create(DTORequestManufacturer created){
        return MapStruct.MAPPER.toDTO(repositoryManufacturer.save(MapStruct.MAPPER.toObject(created)));
    }
    public Page<DTOResponseManufacturer> retrieve(Pageable pageable, String filter){
        switch (pageable.getSort().toString().substring(0, pageable.getSort().toString().length() - 5)) {
            case "id": {
                return repositoryManufacturerPage.findByIdOrderByIdAsc(pageable, UUID.fromString(filter)).map(MapStruct.MAPPER::toDTO);
            }
            default: {
                return repositoryManufacturerPage.findAll(pageable).map(MapStruct.MAPPER::toDTO);
            }
        }
    }
    public DTOResponseManufacturer update(UUID id, DTORequestManufacturer updated){
        return MapStruct.MAPPER.toDTO(repositoryManufacturer.save(MapStruct.MAPPER.toObject(updated)));
    }
    public DTOResponseManufacturer delete(UUID id){
        Manufacturer object = repositoryManufacturer.findById(id).orElse(null);
        repositoryManufacturer.deleteById(id);
        return MapStruct.MAPPER.toDTO(object);
    }
    public void delete() {
        repositoryManufacturer.deleteAll();
    }
    public boolean existsByName(String value) {
        return repositoryManufacturer.existsByNameIgnoreCase(value);
    }
    public boolean existsByNameAndIdNot(String value, UUID id) {
        return repositoryManufacturer.existsByNameIgnoreCaseAndIdNot(value, id);
    }
}