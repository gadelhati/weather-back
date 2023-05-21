package com.observation.service;

import com.observation.persistence.MapStruct;
import com.observation.persistence.model.Harbor;
import com.observation.persistence.payload.request.DTORequestHarbor;
import com.observation.persistence.payload.response.DTOResponseHarbor;
import com.observation.persistence.repository.RepositoryHarbor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service @RequiredArgsConstructor
public class ServiceHarbor implements ServiceInterface<DTOResponseHarbor, DTORequestHarbor, Harbor> {

    private final RepositoryHarbor repositoryHarbor;

    public DTOResponseHarbor create(DTORequestHarbor created){
        return MapStruct.MAPPER.toDTO(repositoryHarbor.save(MapStruct.MAPPER.toObject(created)));
    }
    public DTOResponseHarbor retrieve(UUID id) {
        return MapStruct.MAPPER.toDTO(repositoryHarbor.findById(id).orElse(null));
    }
    public List<DTOResponseHarbor> retrieve(){
        List<DTOResponseHarbor> list = new ArrayList<>();
        for(Harbor harbor: repositoryHarbor.findAll()) {
            list.add(MapStruct.MAPPER.toDTO(harbor));
        }
        return list;
    }
    public Page<DTOResponseHarbor> retrieve(Pageable pageable){
        List<DTOResponseHarbor> list = new ArrayList<>();
        for(Harbor harbor: repositoryHarbor.findAll()) {
            list.add(MapStruct.MAPPER.toDTO(harbor));
        }
        return new PageImpl<DTOResponseHarbor>(list, pageable, list.size());
    }
    public Page<DTOResponseHarbor> retrieve(Pageable pageable, String source){
        final List<DTOResponseHarbor> list = new ArrayList<>();
        if (source == null) {
            for (Harbor harbor : repositoryHarbor.findAll()) {
                list.add(MapStruct.MAPPER.toDTO(harbor));
            }
        } else {
            for (Harbor harbor : repositoryHarbor.findByNameContainingIgnoreCaseOrderByNameAsc(source)) {
                list.add(MapStruct.MAPPER.toDTO(harbor));
            }
        }
        return new PageImpl<>(list, pageable, list.size());
    }
    public DTOResponseHarbor update(UUID id, DTORequestHarbor updated){
        return MapStruct.MAPPER.toDTO(repositoryHarbor.save(MapStruct.MAPPER.toObject(updated)));
    }
    public DTOResponseHarbor delete(UUID id){
        Harbor object = repositoryHarbor.findById(id).orElse(null);
        repositoryHarbor.deleteById(id);
        return MapStruct.MAPPER.toDTO(object);
    }
    public void delete() {
        repositoryHarbor.deleteAll();
    }
    public Harbor findByName(String harbor) { return  repositoryHarbor.findByName(harbor); }
    public boolean existsByNameIgnoreCase(String value) {
        return repositoryHarbor.existsByNameIgnoreCase(value);
    }
    public boolean existsByNameAndIdNot(String value, UUID id) {
        return repositoryHarbor.existsByNameIgnoreCaseAndIdNot(value, id);
    }
}