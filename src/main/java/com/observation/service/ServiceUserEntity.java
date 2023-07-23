package com.observation.service;

import com.observation.persistence.MapStruct;
import com.observation.persistence.model.UserEntity;
import com.observation.persistence.payload.request.DTORequestUserEntity;
import com.observation.persistence.payload.response.DTOResponseUserEntity;
import com.observation.persistence.repository.RepositoryRole;
import com.observation.persistence.repository.RepositoryUserEntity;
import com.observation.persistence.repository.RepositoryUserEntityPage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.UUID;

@Service @RequiredArgsConstructor
public class ServiceUserEntity implements ServiceInterface<DTOResponseUserEntity, DTORequestUserEntity> {

    private final RepositoryUserEntity repositoryUserEntity;
    private final RepositoryRole repositoryRole;
    private final RepositoryUserEntityPage repositoryUserEntityPage;
    private final PasswordEncoder passwordEncoder;

    @Override
    public DTOResponseUserEntity create(DTORequestUserEntity created){
        created.setPassword(passwordEncoder.encode(created.getPassword()));
        created.setRole(Collections.singletonList(repositoryRole.findByName("ROLE_USER")));
        return MapStruct.MAPPER.toDTO(repositoryUserEntity.save(MapStruct.MAPPER.toObject(created)));
    }
    @Override
    public Page<DTOResponseUserEntity> retrieve(Pageable pageable, String key, String value) {
        switch (key) {
            case "id": {
                return repositoryUserEntityPage.findByIdOrderByIdAsc(pageable, UUID.fromString(value)).map(MapStruct.MAPPER::toDTO);
            }
            case "username": {
                return repositoryUserEntityPage.findByUsernameContainingIgnoreCaseOrderByUsernameAsc(pageable, value).map(MapStruct.MAPPER::toDTO);
            }
            default: {
                return repositoryUserEntityPage.findAll(pageable).map(MapStruct.MAPPER::toDTO);
            }
        }
    }
    @Override
    public DTOResponseUserEntity update(UUID id, DTORequestUserEntity updated){
        updated.setPassword(passwordEncoder.encode(updated.getPassword()));
        return MapStruct.MAPPER.toDTO(repositoryUserEntity.save(MapStruct.MAPPER.toObject(updated)));
    }
    @Override
    public DTOResponseUserEntity delete(UUID id){
        DTOResponseUserEntity dtoResponseUserEntity = MapStruct.MAPPER.toDTO(repositoryUserEntity.findById(id).orElse(null));
        repositoryUserEntity.deleteById(id);
        return dtoResponseUserEntity;
    }
    @Override
    public void delete() {
        repositoryUserEntity.deleteAll();
    }

    public boolean existsByName(String value) {
        return repositoryUserEntity.existsByUsernameIgnoreCase(value);
    }
    public boolean existsByNameAndIdNot(String value, UUID id) {
        return repositoryUserEntity.existsByUsernameIgnoreCaseAndIdNot(value, id);
    }
    public boolean existsByEmail(String value) {
        return repositoryUserEntity.existsByEmailIgnoreCase(value);
    }
    public boolean existsByEmailAndIdNot(String value, UUID id) {
        return repositoryUserEntity.existsByEmailIgnoreCaseAndIdNot(value, id);
    }

    public DTOResponseUserEntity changePassword(DTORequestUserEntity updated){
        UserEntity user = repositoryUserEntity.findById(updated.getId()).orElse(null);
        user.setPassword(passwordEncoder.encode(updated.getPassword()));
        return MapStruct.MAPPER.toDTO(repositoryUserEntity.save(user));
    }
}