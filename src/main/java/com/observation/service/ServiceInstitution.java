package com.observation.service;

import com.observation.persistence.MapStruct;
import com.observation.persistence.model.Institution;
import com.observation.persistence.payload.request.DTORequestInstitution;
import com.observation.persistence.payload.response.DTOResponseInstitution;
import com.observation.persistence.repository.RepositoryInstitution;
import com.observation.persistence.repository.RepositoryInstitutionPage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service @RequiredArgsConstructor
public class ServiceInstitution implements ServiceInterface<DTOResponseInstitution, DTORequestInstitution> {

    private final RepositoryInstitution repositoryInstitution;
    private final RepositoryInstitutionPage repositoryInstitutionPage;

    public DTOResponseInstitution create(DTORequestInstitution created){
        return MapStruct.MAPPER.toDTO(repositoryInstitution.save(MapStruct.MAPPER.toObject(created)));
    }
    public Page<DTOResponseInstitution> retrieve(Pageable pageable, String key, String value){
        switch (key) {
            case "id": {
                return repositoryInstitutionPage.findByIdOrderByIdAsc(pageable, UUID.fromString(value)).map(MapStruct.MAPPER::toDTO);
            }
            case "name": {
                return repositoryInstitutionPage.findByNameContainingIgnoreCaseOrderByNameAsc(pageable, value).map(MapStruct.MAPPER::toDTO);
            }
            default: {
                return repositoryInstitutionPage.findAll(pageable).map(MapStruct.MAPPER::toDTO);
            }
        }
    }
    public DTOResponseInstitution update(UUID id, DTORequestInstitution updated){
        return MapStruct.MAPPER.toDTO(repositoryInstitution.save(MapStruct.MAPPER.toObject(updated)));
    }
    public DTOResponseInstitution delete(UUID id){
        Institution object = repositoryInstitution.findById(id).orElse(null);
        repositoryInstitution.deleteById(id);
        return MapStruct.MAPPER.toDTO(object);
    }
    public void delete() {
        repositoryInstitution.deleteAll();
    }
    public boolean existsByName(String value) {
        return repositoryInstitution.existsByNameIgnoreCase(value);
    }
    public boolean existsByNameAndIdNot(String value, UUID id) {
        return repositoryInstitution.existsByNameIgnoreCaseAndIdNot(value, id);
    }
}