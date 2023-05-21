package com.observation.persistence.model;

import jakarta.persistence.Entity;
import lombok.*;
import org.hibernate.envers.Audited;

@Audited @Entity @Setter @Getter @AllArgsConstructor @NoArgsConstructor
public class Privilege extends GenericEntity {

    private String name;

//    @ManyToMany(mappedBy = "privileges")
//    private Set<Role> roles = new HashSet<>();
}