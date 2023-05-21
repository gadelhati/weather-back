package com.observation.service;

import com.observation.persistence.MapStruct;
import com.observation.persistence.model.FederativeUnit;
import com.observation.persistence.payload.request.DTORequestFederativeUnit;
import com.observation.persistence.payload.response.DTOResponseFederativeUnit;
import com.observation.persistence.repository.RepositoryFederativeUnit;
import com.observation.persistence.repository.RepositoryFederativeUnitPage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service @RequiredArgsConstructor
public class ServiceFederativeUnit implements ServiceInterface<DTOResponseFederativeUnit, DTORequestFederativeUnit> {

    private final RepositoryFederativeUnit repositoryFederativeUnit;
    private final RepositoryFederativeUnitPage repositoryFederativeUnitPage;

    public DTOResponseFederativeUnit create(DTORequestFederativeUnit created){
        return MapStruct.MAPPER.toDTO(repositoryFederativeUnit.save(MapStruct.MAPPER.toObject(created)));
    }
    public Page<DTOResponseFederativeUnit> retrieve(Pageable pageable, String filter){
        switch (pageable.getSort().toString().substring(0, pageable.getSort().toString().length() - 5)) {
            case "id": {
                return repositoryFederativeUnitPage.findByIdOrderByIdAsc(pageable, UUID.fromString(filter)).map(MapStruct.MAPPER::toDTO);
            }
            default: {
                return repositoryFederativeUnitPage.findAll(pageable).map(MapStruct.MAPPER::toDTO);
            }
        }
    }
    public DTOResponseFederativeUnit update(UUID id, DTORequestFederativeUnit updated){
        return MapStruct.MAPPER.toDTO(repositoryFederativeUnit.save(MapStruct.MAPPER.toObject(updated)));
    }
    public DTOResponseFederativeUnit delete(UUID id){
        FederativeUnit object = repositoryFederativeUnit.findById(id).orElse(null);
        repositoryFederativeUnit.deleteById(id);
        return MapStruct.MAPPER.toDTO(object);
    }
    public void delete() {
        repositoryFederativeUnit.deleteAll();
    }
    public boolean existsByName(String value) {
        return repositoryFederativeUnit.existsByNameIgnoreCase(value);
    }
    public boolean existsByNameAndIdNot(String value, UUID id) {
        return repositoryFederativeUnit.existsByNameIgnoreCaseAndIdNot(value, id);
    }
}