package com.observation.service;

import com.observation.persistence.MapStruct;
import com.observation.persistence.model.State;
import com.observation.persistence.payload.request.DTORequestState;
import com.observation.persistence.payload.response.DTOResponseState;
import com.observation.persistence.repository.RepositoryState;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service @RequiredArgsConstructor
public class ServiceState {

    private final RepositoryState repositoryState;

    public DTOResponseState create(DTORequestState created){
        return MapStruct.MAPPER.toDTO(repositoryState.save(MapStruct.MAPPER.toObject(created)));
    }
    public Page<DTOResponseState> retrieve(Pageable pageable, String key, String value){
        switch (key) {
            case "id": {
                return repositoryState.findByIdOrderByIdAsc(pageable, Long.parseLong(value)).map(MapStruct.MAPPER::toDTO);
            }
            case "name": {
                return repositoryState.findByNameContainingIgnoreCaseOrderByNameAsc(pageable, value).map(MapStruct.MAPPER::toDTO);
            }
            default: {
                return repositoryState.findAll(pageable).map(MapStruct.MAPPER::toDTO);
            }
        }
    }
    public DTOResponseState update(long id, DTORequestState updated){
        return MapStruct.MAPPER.toDTO(repositoryState.save(MapStruct.MAPPER.toObject(updated)));
    }
    public DTOResponseState delete(long id){
        State object = repositoryState.findById(id).orElse(null);
        repositoryState.deleteById(id);
        return MapStruct.MAPPER.toDTO(object);
    }
    public void delete() {
        repositoryState.deleteAll();
    }
    public boolean existsByName(String value) {
        return repositoryState.existsByNameIgnoreCase(value);
    }
    public boolean existsByNameAndIdNot(String value, long id) {
        return repositoryState.existsByNameIgnoreCaseAndIdNot(value, id);
    }
}