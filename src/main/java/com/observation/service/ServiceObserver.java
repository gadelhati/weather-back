package com.observation.service;

import com.observation.persistence.MapStruct;
import com.observation.persistence.model.Observer;
import com.observation.persistence.payload.request.DTORequestObserver;
import com.observation.persistence.payload.response.DTOResponseObserver;
import com.observation.persistence.repository.RepositoryObserver;
import com.observation.persistence.repository.RepositoryObserverPage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service @RequiredArgsConstructor
public class ServiceObserver implements ServiceInterface<DTOResponseObserver, DTORequestObserver> {

    private final RepositoryObserver repositoryObserver;
    private final RepositoryObserverPage repositoryObserverPage;

    public DTOResponseObserver create(DTORequestObserver created){
        return MapStruct.MAPPER.toDTO(repositoryObserver.save(MapStruct.MAPPER.toObject(created)));
    }
    public Page<DTOResponseObserver> retrieve(Pageable pageable, String filter){
        switch (pageable.getSort().toString().substring(0, pageable.getSort().toString().length() - 5)) {
            case "id": {
                return repositoryObserverPage.findByIdOrderByIdAsc(pageable, UUID.fromString(filter)).map(MapStruct.MAPPER::toDTO);
            }
            default: {
                return repositoryObserverPage.findAll(pageable).map(MapStruct.MAPPER::toDTO);
            }
        }
    }
    public DTOResponseObserver update(UUID id, DTORequestObserver updated){
        return MapStruct.MAPPER.toDTO(repositoryObserver.save(MapStruct.MAPPER.toObject(updated)));
    }
    public DTOResponseObserver delete(UUID id){
        Observer object = repositoryObserver.findById(id).orElse(null);
        repositoryObserver.deleteById(id);
        return MapStruct.MAPPER.toDTO(object);
    }
    public void delete() {
        repositoryObserver.deleteAll();
    }
    public boolean existsByName(String value) {
        return repositoryObserver.existsByNameIgnoreCase(value);
    }
    public boolean existsByNameAndIdNot(String value, UUID id) {
        return repositoryObserver.existsByNameIgnoreCaseAndIdNot(value, id);
    }
    public boolean existsByNIP(String value) {
        return repositoryObserver.existsByNipIgnoreCase(value);
    }
    public boolean existsByNIPAndIdNot(String value, UUID id) {
        return repositoryObserver.existsByNipIgnoreCaseAndIdNot(value, id);
    }
}