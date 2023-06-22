package com.observation.service;

import com.observation.persistence.MapStruct;
import com.observation.persistence.model.Country;
import com.observation.persistence.payload.request.DTORequestCountry;
import com.observation.persistence.payload.response.DTOResponseCountry;
import com.observation.persistence.repository.RepositoryCountry;
import com.observation.persistence.repository.RepositoryCountryPage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service @RequiredArgsConstructor
public class ServiceCountry implements ServiceInterface<DTOResponseCountry, DTORequestCountry> {

    private final RepositoryCountry repositoryCountry;
    private final RepositoryCountryPage repositoryCountryPage;

    public DTOResponseCountry create(DTORequestCountry created){
        return MapStruct.MAPPER.toDTO(repositoryCountry.save(MapStruct.MAPPER.toObject(created)));
    }
    public Page<DTOResponseCountry> retrieve(Pageable pageable, String key, String value){
        switch (key) {
            case "id": {
                return repositoryCountryPage.findByIdOrderByIdAsc(pageable, UUID.fromString(value)).map(MapStruct.MAPPER::toDTO);
            }
            default: {
                return repositoryCountryPage.findAll(pageable).map(MapStruct.MAPPER::toDTO);
            }
        }
    }
    public DTOResponseCountry update(UUID id, DTORequestCountry updated){
        return MapStruct.MAPPER.toDTO(repositoryCountry.save(MapStruct.MAPPER.toObject(updated)));
    }
    public DTOResponseCountry delete(UUID id){
        Country object = repositoryCountry.findById(id).orElse(null);
        repositoryCountry.deleteById(id);
        return MapStruct.MAPPER.toDTO(object);
    }
    public void delete() {
        repositoryCountry.deleteAll();
    }
    public boolean existsByName(String value) {
        return repositoryCountry.existsByNameIgnoreCase(value);
    }
    public boolean existsByNameAndIdNot(String value, UUID id) {
        return repositoryCountry.existsByNameIgnoreCaseAndIdNot(value, id);
    }
}