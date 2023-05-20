package br.eti.observation.service;

import br.eti.observation.persistence.MapStruct;
import br.eti.observation.persistence.model.Privilege;
import br.eti.observation.persistence.payload.request.DTORequestPrivilege;
import br.eti.observation.persistence.payload.response.DTOResponsePrivilege;
import br.eti.observation.persistence.repository.RepositoryPrivilege;
import br.eti.observation.persistence.repository.RepositoryPrivilegePage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service @RequiredArgsConstructor
public class ServicePrivilege implements ServiceInterface<DTOResponsePrivilege, DTORequestPrivilege, Privilege> {

    private final RepositoryPrivilege repositoryPrivilege;
    private final RepositoryPrivilegePage repositoryPrivilegePage;

    @Override
    public DTOResponsePrivilege create(DTORequestPrivilege created){
        return MapStruct.MAPPER.toDTO(repositoryPrivilege.save(MapStruct.MAPPER.toObject(created)));
    }

    @Override
    public DTOResponsePrivilege retrieve(UUID id) {
        return null;
    }

    @Override
    public List<DTOResponsePrivilege> retrieve() {
        return null;
    }

    @Override
    public Page<DTOResponsePrivilege> retrieve(Pageable pageable) {
        return null;
    }

    @Override
    public Page<DTOResponsePrivilege> retrieve(Pageable pageable, String filter) {
        switch (pageable.getSort().toString().substring(0, pageable.getSort().toString().length() - 5)) {
            case "id": {
                return repositoryPrivilegePage.findByIdOrderByIdAsc(pageable, UUID.fromString(filter)).map(MapStruct.MAPPER::toDTO);
            }
            case "name": {
                return repositoryPrivilegePage.findByNameContainingIgnoreCaseOrderByNameAsc(pageable, filter).map(MapStruct.MAPPER::toDTO);
            }
            default: {
                return repositoryPrivilegePage.findAll(pageable).map(MapStruct.MAPPER::toDTO);
            }
        }
    }
    @Override
    public DTOResponsePrivilege update(UUID id, DTORequestPrivilege updated){
        return MapStruct.MAPPER.toDTO(repositoryPrivilege.save(MapStruct.MAPPER.toObject(updated)));
    }
    @Override
    public DTOResponsePrivilege delete(UUID id){
        DTOResponsePrivilege dtoResponsePrivilege = MapStruct.MAPPER.toDTO(repositoryPrivilege.findById(id).orElse(null));
        repositoryPrivilege.deleteById(id);
        return dtoResponsePrivilege;
    }
    @Override
    public void delete() {
        repositoryPrivilege.deleteAll();
    }

    @Override
    public Privilege findByName(String value) {
        return null;
    }

    @Override
    public boolean existsByNameIgnoreCase(String value) {
        return false;
    }

    public boolean existsByName(String value) {
        return repositoryPrivilege.existsByNameIgnoreCase(value);
    }
    public boolean existsByNameAndIdNot(String value, UUID id) {
        return repositoryPrivilege.existsByNameIgnoreCaseAndIdNot(value, id);
    }
}