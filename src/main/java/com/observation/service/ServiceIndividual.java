package com.observation.service;

import com.observation.persistence.MapStruct;
import com.observation.persistence.model.Individual;
import com.observation.persistence.payload.request.DTORequestIndividual;
import com.observation.persistence.payload.response.DTOResponseIndividual;
import com.observation.persistence.repository.RepositoryIndividual;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service @RequiredArgsConstructor
public class ServiceIndividual implements ServiceInterface<DTOResponseIndividual, DTORequestIndividual, Individual> {

    private final RepositoryIndividual repositoryIndividual;

    public DTOResponseIndividual create(DTORequestIndividual created){
        return MapStruct.MAPPER.toDTO(repositoryIndividual.save(MapStruct.MAPPER.toObject(created)));
    }
    public List<DTOResponseIndividual> retrieve(){
        List<DTOResponseIndividual> list = new ArrayList<>();
        for(Individual om: repositoryIndividual.findAll()) {
            list.add(MapStruct.MAPPER.toDTO(om));
        }
        return list;
    }
    public Page<DTOResponseIndividual> retrieve(Pageable pageable){
        List<DTOResponseIndividual> list = new ArrayList<>();
        for(Individual role: repositoryIndividual.findAll()) {
            list.add(MapStruct.MAPPER.toDTO(role));
        }
        return new PageImpl<DTOResponseIndividual>(list, pageable, list.size());
    }
    public Page<DTOResponseIndividual> retrieve(Pageable pageable, String source) {
        List<DTOResponseIndividual> list = new ArrayList<>();
        for(Individual object: repositoryIndividual.findAll()) {
            list.add(MapStruct.MAPPER.toDTO(object));
        }
        return new PageImpl<DTOResponseIndividual>(list, pageable, list.size());
    }
    public DTOResponseIndividual retrieve(UUID id){
        return MapStruct.MAPPER.toDTO(repositoryIndividual.findById(id).orElse(null));
    }
    public Page<DTOResponseIndividual> retrieveSource(Pageable pageable, String source){
        final List<DTOResponseIndividual> list = new ArrayList<>();
        if (source == null) {
            for (Individual role : repositoryIndividual.findAll()) {
                list.add(MapStruct.MAPPER.toDTO(role));
            }
        } else {
            for (Individual role : repositoryIndividual.findByNameContainingIgnoreCaseOrderByNameAsc(source)) {
                list.add(MapStruct.MAPPER.toDTO(role));
            }
        }
        return new PageImpl<>(list, pageable, list.size());
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
    public Individual findByName(String value) { return  repositoryIndividual.findByName(value); }
    public boolean existsByNameIgnoreCase(String value) {
        return repositoryIndividual.existsByNameIgnoreCase(value);
    }
}