package com.observation.service;

import com.observation.persistence.MapStruct;
import com.observation.persistence.model.Surveying;
import com.observation.persistence.payload.request.DTORequestSurveying;
import com.observation.persistence.payload.response.DTOResponseSurveying;
import com.observation.persistence.repository.RepositorySurveying;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service @RequiredArgsConstructor
public class ServiceSurveying implements ServiceInterface<DTOResponseSurveying, DTORequestSurveying> {

    private final RepositorySurveying repositorySurveying;

    public DTOResponseSurveying create(DTORequestSurveying created){
        return MapStruct.MAPPER.toDTO(repositorySurveying.save(MapStruct.MAPPER.toObject(created)));
    }
    public Page<DTOResponseSurveying> retrieve(Pageable pageable, String key, String value){
        switch (key) {
            case "id": {
                return repositorySurveying.findByIdOrderByIdAsc(pageable, UUID.fromString(value)).map(MapStruct.MAPPER::toDTO);
            }
            case "name": {
                return repositorySurveying.findByNameContainingIgnoreCaseOrderByNameAsc(pageable, value).map(MapStruct.MAPPER::toDTO);
            }
            default: {
                return repositorySurveying.findAll(pageable).map(MapStruct.MAPPER::toDTO);
            }
        }
    }
    public DTOResponseSurveying update(UUID id, DTORequestSurveying updated){
        return MapStruct.MAPPER.toDTO(repositorySurveying.save(MapStruct.MAPPER.toObject(updated)));
    }
    public DTOResponseSurveying delete(UUID id){
        Surveying object = repositorySurveying.findById(id).orElse(null);
        repositorySurveying.deleteById(id);
        return MapStruct.MAPPER.toDTO(object);
    }
    public void delete() {
        repositorySurveying.deleteAll();
    }
    public boolean existsByName(String value) {
        return repositorySurveying.existsByNameIgnoreCase(value);
    }
    public boolean existsByNameAndIdNot(String value, UUID id) {
        return repositorySurveying.existsByNameIgnoreCaseAndIdNot(value, id);
    }
}