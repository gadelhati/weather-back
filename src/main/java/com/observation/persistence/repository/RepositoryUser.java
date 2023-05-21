package com.observation.persistence.repository;

import com.observation.persistence.model.OM;
import com.observation.persistence.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RepositoryUser extends JpaRepository<User, UUID> {
    List<User> findByUsernameContainingIgnoreCaseOrderByUsernameAsc(String name);
    boolean existsByUsername(String value);
    boolean existsByEmail(String email);
    User getUserByUsername(@Param("username") String username);
    Optional<User> findByUsername(String username);
    List<User> findByOm(OM om);
    boolean existsByUsernameContainingIgnoreCase(String value);
    boolean existsByEmailContainingIgnoreCase(String value);
    boolean existsByEmailIgnoreCase(String value);
    boolean existsByEmailIgnoreCaseAndIdNot(String name, UUID id);
    boolean existsByUsernameIgnoreCase(String value);
    boolean existsByUsernameIgnoreCaseAndIdNot(String name, UUID id);
}