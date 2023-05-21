package com.observation.service;

import com.observation.persistence.MapStruct;
import com.observation.persistence.model.Company;
import com.observation.persistence.payload.request.DTORequestCompany;
import com.observation.persistence.payload.response.DTOResponseCompany;
import com.observation.persistence.repository.RepositoryCompany;
import com.observation.persistence.repository.RepositoryCompanyPage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service @RequiredArgsConstructor
public class ServiceCompany implements ServiceInterface<DTOResponseCompany, DTORequestCompany> {

    private final RepositoryCompany repositoryCompany;
    private final RepositoryCompanyPage repositoryCompanyPage;

    public DTOResponseCompany create(DTORequestCompany created){
        return MapStruct.MAPPER.toDTO(repositoryCompany.save(MapStruct.MAPPER.toObject(created)));
    }
    public Page<DTOResponseCompany> retrieve(Pageable pageable, String filter){
        switch (pageable.getSort().toString().substring(0, pageable.getSort().toString().length() - 5)) {
            case "id": {
                return repositoryCompanyPage.findByIdOrderByIdAsc(pageable, UUID.fromString(filter)).map(MapStruct.MAPPER::toDTO);
            }
            default: {
                return repositoryCompanyPage.findAll(pageable).map(MapStruct.MAPPER::toDTO);
            }
        }
    }
    public DTOResponseCompany update(UUID id, DTORequestCompany updated){
        return MapStruct.MAPPER.toDTO(repositoryCompany.save(MapStruct.MAPPER.toObject(updated)));
    }
    public DTOResponseCompany delete(UUID id){
        Company object = repositoryCompany.findById(id).orElse(null);
        repositoryCompany.deleteById(id);
        return MapStruct.MAPPER.toDTO(object);
    }
    public void delete() {
        repositoryCompany.deleteAll();
    }
    public boolean existsByName(String value) {
        return repositoryCompany.existsByNameIgnoreCase(value);
    }
    public boolean existsByNameAndIdNot(String value, UUID id) {
        return repositoryCompany.existsByNameIgnoreCaseAndIdNot(value, id);
    }
}