package com.observation.service;

import com.observation.persistence.MapStruct;
import com.observation.persistence.model.Observer;
import com.observation.persistence.payload.request.DTORequestObserver;
import com.observation.persistence.payload.response.DTOResponseObserver;
import com.observation.persistence.repository.RepositoryObserver;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service @RequiredArgsConstructor
public class ServiceObserver implements ServiceInterface<DTOResponseObserver, DTORequestObserver, Observer> {

    private final RepositoryObserver repositoryObserver;

    public DTOResponseObserver create(DTORequestObserver created){
        return MapStruct.MAPPER.toDTO(repositoryObserver.save(MapStruct.MAPPER.toObject(created)));
    }
    public DTOResponseObserver retrieve(UUID id){
        return MapStruct.MAPPER.toDTO(repositoryObserver.findById(id).orElse(null));
    }
    public List<DTOResponseObserver> retrieve(){
        List<DTOResponseObserver> list = new ArrayList<>();
        for(Observer object: repositoryObserver.findAll()) {
            list.add(MapStruct.MAPPER.toDTO(object));
        }
        return list;
    }
    public Page<DTOResponseObserver> retrieve(Pageable pageable){
        List<DTOResponseObserver> list = new ArrayList<>();
        for(Observer object: repositoryObserver.findAll()) {
            list.add(MapStruct.MAPPER.toDTO(object));
        }
        return new PageImpl<DTOResponseObserver>(list, pageable, list.size());
    }
    public Page<DTOResponseObserver> retrieve(Pageable pageable, String source){
        final List<DTOResponseObserver> list = new ArrayList<>();
        if (source == null) {
            for (Observer object : repositoryObserver.findAll()) {
                list.add(MapStruct.MAPPER.toDTO(object));
            }
        } else {
            for (Observer object : repositoryObserver.findByNameContainingIgnoreCaseOrderByNameAsc(source)) {
                list.add(MapStruct.MAPPER.toDTO(object));
            }
        }
        return new PageImpl<>(list, pageable, list.size());
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
    public Observer findByName(String value) { return  repositoryObserver.findByName(value); }
    public boolean existsByNameIgnoreCase(String value) {
        return repositoryObserver.existsByNameIgnoreCase(value);
    }
    public boolean existsByNipIgnoreCase(String value) {
        return repositoryObserver.existsByNipIgnoreCase(value);
    }
    public boolean existsByNameAndIdNot(String nip, UUID id) {
        return !repositoryObserver.findByNameContaining(nip).and(repositoryObserver.findByIdNot(id)).isEmpty();
    }
    public boolean existsByNipIgnoreCaseAndIdNot(String value, UUID id) {
        return repositoryObserver.existsByNipIgnoreCaseAndIdNot(value, id);
    }
}