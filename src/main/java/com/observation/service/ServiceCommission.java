package com.observation.service;

import com.observation.persistence.MapStruct;
import com.observation.persistence.model.Commission;
import com.observation.persistence.payload.request.DTORequestCommission;
import com.observation.persistence.payload.response.DTOResponseCommission;
import com.observation.persistence.repository.RepositoryCommission;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service @RequiredArgsConstructor
public class ServiceCommission implements ServiceInterface<DTOResponseCommission, DTORequestCommission, Commission> {

    private final RepositoryCommission repositoryCommission;

    public DTOResponseCommission create(DTORequestCommission created){
        return MapStruct.MAPPER.toDTO(repositoryCommission.save(MapStruct.MAPPER.toObject(created)));
    }
    public DTOResponseCommission retrieve(UUID id) {
        return MapStruct.MAPPER.toDTO(repositoryCommission.findById(id).orElse(null));
    }
    public List<DTOResponseCommission> retrieve(){
        List<DTOResponseCommission> list = new ArrayList<>();
        for(Commission commission: repositoryCommission.findAll()) {
            list.add(MapStruct.MAPPER.toDTO(commission));
        }
        return list;
    }
    public Page<DTOResponseCommission> retrieve(Pageable pageable){
        List<DTOResponseCommission> list = new ArrayList<>();
        for(Commission commission: repositoryCommission.findAll()) {
            list.add(MapStruct.MAPPER.toDTO(commission));
        }
        return new PageImpl<DTOResponseCommission>(list, pageable, list.size());
    }
    public Page<DTOResponseCommission> retrieve(Pageable pageable, String source){
        final List<DTOResponseCommission> list = new ArrayList<>();
        if (source == null) {
            for (Commission commission : repositoryCommission.findAll()) {
                list.add(MapStruct.MAPPER.toDTO(commission));
            }
        } else {
            for (Commission commission : repositoryCommission.findByNameContainingIgnoreCaseOrderByNameAsc(source)) {
                list.add(MapStruct.MAPPER.toDTO(commission));
            }
        }
        return new PageImpl<>(list, pageable, list.size());
    }
    public DTOResponseCommission update(UUID id, DTORequestCommission updated){
        return MapStruct.MAPPER.toDTO(repositoryCommission.save(MapStruct.MAPPER.toObject(updated)));
    }
    public DTOResponseCommission delete(UUID id){
        Commission object = repositoryCommission.findById(id).orElse(null);
        repositoryCommission.deleteById(id);
        return MapStruct.MAPPER.toDTO(object);
    }
    public void delete() {
        repositoryCommission.deleteAll();
    }
    public Commission findByName(String commission) { return  repositoryCommission.findByName(commission); }
    public boolean existsByNameIgnoreCase(String value) {
        return repositoryCommission.existsByNameIgnoreCase(value);
    }
}