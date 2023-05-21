package com.observation.service;

import com.observation.persistence.MapStruct;
import com.observation.persistence.model.PlatformCategory;
import com.observation.persistence.payload.request.DTORequestPlatformCategory;
import com.observation.persistence.payload.response.DTOResponsePlatformCategory;
import com.observation.persistence.repository.RepositoryPlatformCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service @RequiredArgsConstructor
public class ServicePlatformCategory implements ServiceInterface<DTOResponsePlatformCategory, DTORequestPlatformCategory, PlatformCategory> {

    private final RepositoryPlatformCategory repositoryPlatformCategory;

    public DTOResponsePlatformCategory create(DTORequestPlatformCategory created){
        return MapStruct.MAPPER.toDTO(repositoryPlatformCategory.save(MapStruct.MAPPER.toObject(created)));
    }
    public DTOResponsePlatformCategory retrieve(UUID id){
        return MapStruct.MAPPER.toDTO(repositoryPlatformCategory.findById(id).orElse(null));
    }
    public List<DTOResponsePlatformCategory> retrieve(){
        List<DTOResponsePlatformCategory> list = new ArrayList<>();
        for(PlatformCategory object: repositoryPlatformCategory.findAll()) {
            list.add(MapStruct.MAPPER.toDTO(object));
        }
        return list;
    }
    public Page<DTOResponsePlatformCategory> retrieve(Pageable pageable){
        List<DTOResponsePlatformCategory> list = new ArrayList<>();
        for(PlatformCategory object: repositoryPlatformCategory.findAll()) {
            list.add(MapStruct.MAPPER.toDTO(object));
        }
        return new PageImpl<DTOResponsePlatformCategory>(list, pageable, list.size());
    }
    public Page<DTOResponsePlatformCategory> retrieve(Pageable pageable, String source){
        final List<DTOResponsePlatformCategory> list = new ArrayList<>();
        if (source == null) {
            for (PlatformCategory object : repositoryPlatformCategory.findAll()) {
                list.add(MapStruct.MAPPER.toDTO(object));
            }
        } else {
            for (PlatformCategory object : repositoryPlatformCategory.findByNameContainingIgnoreCaseOrderByNameAsc(source)) {
                list.add(MapStruct.MAPPER.toDTO(object));
            }
        }
        return new PageImpl<>(list, pageable, list.size());
    }
    public DTOResponsePlatformCategory update(UUID id, DTORequestPlatformCategory updated){
        return MapStruct.MAPPER.toDTO(repositoryPlatformCategory.save(MapStruct.MAPPER.toObject(updated)));
    }
    public DTOResponsePlatformCategory delete(UUID id){
        PlatformCategory object = repositoryPlatformCategory.findById(id).orElse(null);
        repositoryPlatformCategory.deleteById(id);
        return MapStruct.MAPPER.toDTO(object);
    }
    public void delete() {
        repositoryPlatformCategory.deleteAll();
    }
    public PlatformCategory findByName(String value) { return  repositoryPlatformCategory.findByName(value); }
    public boolean existsByNameIgnoreCase(String value) {
        return repositoryPlatformCategory.existsByNameIgnoreCase(value);
    }
    public boolean existsByNameIgnoreCaseAndIdNot(String value, UUID id) {
        return repositoryPlatformCategory.existsByNameIgnoreCaseAndIdNot(value, id);
    }
}