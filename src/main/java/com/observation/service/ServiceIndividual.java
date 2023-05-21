package com.observation.service;

import com.observation.persistence.MapStruct;
import com.observation.persistence.model.Individual;
import com.observation.persistence.payload.request.DTORequestIndividual;
import com.observation.persistence.payload.response.DTOResponseIndividual;
import com.observation.persistence.repository.RepositoryIndividual;
import com.observation.persistence.repository.RepositoryIndividualPage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service @RequiredArgsConstructor
public class ServiceIndividual implements ServiceInterface<DTOResponseIndividual, DTORequestIndividual> {

    private final RepositoryIndividual repositoryIndividual;
    private final RepositoryIndividualPage repositoryIndividualPage;

    public DTOResponseIndividual create(DTORequestIndividual created){
        return MapStruct.MAPPER.toDTO(repositoryIndividual.save(MapStruct.MAPPER.toObject(created)));
    }
    public Page<DTOResponseIndividual> retrieve(Pageable pageable, String filter){
        switch (pageable.getSort().toString().substring(0, pageable.getSort().toString().length() - 5)) {
            case "id": {
                return repositoryIndividualPage.findByIdOrderByIdAsc(pageable, UUID.fromString(filter)).map(MapStruct.MAPPER::toDTO);
            }
            default: {
                return repositoryIndividualPage.findAll(pageable).map(MapStruct.MAPPER::toDTO);
            }
        }
    }
    public DTOResponseIndividual update(UUID id, DTORequestIndividual updated){
        return MapStruct.MAPPER.toDTO(repositoryIndividual.save(MapStruct.MAPPER.toObject(updated)));
    }
    public DTOResponseIndividual delete(UUID id){
        Individual object = repositoryIndividual.findById(id).orElse(null);
        repositoryIndividual.deleteById(id);
        return MapStruct.MAPPER.toDTO(object);
    }
    public void delete() {
        repositoryIndividual.deleteAll();
    }
    public boolean existsByName(String value) {
        return repositoryIndividual.existsByNameIgnoreCase(value);
    }
    public boolean existsByNameAndIdNot(String value, UUID id) {
        return repositoryIndividual.existsByNameIgnoreCaseAndIdNot(value, id);
    }
}