package com.observation.service;

import com.observation.persistence.MapStruct;
import com.observation.persistence.model.Privilege;
import com.observation.persistence.payload.request.DTORequestPrivilege;
import com.observation.persistence.payload.response.DTOResponsePrivilege;
import com.observation.persistence.repository.RepositoryPrivilege;
import com.observation.persistence.repository.RepositoryPrivilegePage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service @RequiredArgsConstructor
public class ServicePrivilege implements ServiceInterface<DTOResponsePrivilege, DTORequestPrivilege> {

    private final RepositoryPrivilege repositoryPrivilege;
    private final RepositoryPrivilegePage repositoryPrivilegePage;

    public DTOResponsePrivilege create(DTORequestPrivilege created){
        return MapStruct.MAPPER.toDTO(repositoryPrivilege.save(MapStruct.MAPPER.toObject(created)));
    }
    public Page<DTOResponsePrivilege> retrieve(Pageable pageable, String key, String value){
        switch (key) {
            case "id": {
                return repositoryPrivilegePage.findByIdOrderByIdAsc(pageable, UUID.fromString(value)).map(MapStruct.MAPPER::toDTO);
            }
            default: {
                return repositoryPrivilegePage.findAll(pageable).map(MapStruct.MAPPER::toDTO);
            }
        }
    }
    public DTOResponsePrivilege update(UUID id, DTORequestPrivilege updated){
        return MapStruct.MAPPER.toDTO(repositoryPrivilege.save(MapStruct.MAPPER.toObject(updated)));
    }
    public DTOResponsePrivilege delete(UUID id){
        Privilege object = repositoryPrivilege.findById(id).orElse(null);
        repositoryPrivilege.deleteById(id);
        return MapStruct.MAPPER.toDTO(object);
    }
    public void delete() {
        repositoryPrivilege.deleteAll();
    }
    public boolean existsByName(String value) {
        return repositoryPrivilege.existsByNameIgnoreCase(value);
    }
    public boolean existsByNameAndIdNot(String value, UUID id) {
        return repositoryPrivilege.existsByNameIgnoreCaseAndIdNot(value, id);
    }
}