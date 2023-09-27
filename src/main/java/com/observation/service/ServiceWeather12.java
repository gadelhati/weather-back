package com.observation.service;

import com.observation.persistence.MapStruct;
import com.observation.persistence.payload.request.DTORequestWeather12;
import com.observation.persistence.payload.response.DTOResponseWeather12;
import com.observation.persistence.repository.RepositoryWeather12;
import com.observation.persistence.repository.RepositoryWeather12Page;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service @RequiredArgsConstructor
public class ServiceWeather12 implements ServiceInterface<DTOResponseWeather12, DTORequestWeather12> {

    private final RepositoryWeather12 repositoryWeather12;
    private final RepositoryWeather12Page repositoryWeather12Page;

    public DTOResponseWeather12 create(DTORequestWeather12 created){
        return MapStruct.MAPPER.toDTO(repositoryWeather12.save(MapStruct.MAPPER.toObject(created)));
    }
    public Page<DTOResponseWeather12> retrieve(Pageable pageable, String key, String value) {
        switch (key) {
            case "id": {
                return repositoryWeather12Page.findByIdOrderByIdAsc(pageable, UUID.fromString(value)).map(MapStruct.MAPPER::toDTO);
            }
            default: {
                return repositoryWeather12Page.findAll(pageable).map(MapStruct.MAPPER::toDTO);
            }
        }
    }
    public DTOResponseWeather12 update(UUID id, DTORequestWeather12 updated){
        return MapStruct.MAPPER.toDTO(repositoryWeather12.save(MapStruct.MAPPER.toObject(updated)));
    }
    public DTOResponseWeather12 delete(UUID id){
        DTOResponseWeather12 dtoResponseWeather12 = MapStruct.MAPPER.toDTO(repositoryWeather12.findById(id).orElse(null));
        repositoryWeather12.deleteById(id);
        return dtoResponseWeather12;
    }
    public void delete() {
        repositoryWeather12.deleteAll();
    }

}