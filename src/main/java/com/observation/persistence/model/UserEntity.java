package com.observation.persistence.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

import java.util.Collection;

@Audited @Entity @Setter @Getter @AllArgsConstructor @NoArgsConstructor
public class UserEntity extends GenericEntity {

    private String username;
    private String email;
    private String password;
    private Boolean active;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Collection<Role> role;

    public UserEntity(String username, String email, String password, boolean active) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.active = active;
    }
    public UserEntity(String username, String password, Collection<Role> role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
}