package com.observation.service;

import com.observation.persistence.MapStruct;
import com.observation.persistence.model.City;
import com.observation.persistence.payload.request.DTORequestCity;
import com.observation.persistence.payload.response.DTOResponseCity;
import com.observation.persistence.repository.RepositoryCity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service @RequiredArgsConstructor
public class ServiceCity {

    private final RepositoryCity repositoryCity;

    public DTOResponseCity create(DTORequestCity created){
        return MapStruct.MAPPER.toDTO(repositoryCity.save(MapStruct.MAPPER.toObject(created)));
    }
    public Page<DTOResponseCity> retrieve(Pageable pageable, String key, String value){
        switch (key) {
            case "id": {
                return repositoryCity.findByIdOrderByIdAsc(pageable, Long.parseLong(value)).map(MapStruct.MAPPER::toDTO);
            }
            case "name": {
                return repositoryCity.findByNameContainingIgnoreCaseOrderByNameAsc(pageable, value).map(MapStruct.MAPPER::toDTO);
            }
            default: {
                return repositoryCity.findAll(pageable).map(MapStruct.MAPPER::toDTO);
            }
        }
    }
    public DTOResponseCity update(long id, DTORequestCity updated){
        return MapStruct.MAPPER.toDTO(repositoryCity.save(MapStruct.MAPPER.toObject(updated)));
    }
    public DTOResponseCity delete(long id){
        City object = repositoryCity.findById(id).orElse(null);
        repositoryCity.deleteById(id);
        return MapStruct.MAPPER.toDTO(object);
    }
    public void delete() {
        repositoryCity.deleteAll();
    }
    public boolean existsByName(String value) {
        return repositoryCity.existsByNameIgnoreCase(value);
    }
    public boolean existsByNameAndIdNot(String value, long id) {
        return repositoryCity.existsByNameIgnoreCaseAndIdNot(value, id);
    }
}