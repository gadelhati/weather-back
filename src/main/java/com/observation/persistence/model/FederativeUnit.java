package com.observation.persistence.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

@Audited @Entity @Data @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode(callSuper = false) @Table(uniqueConstraints = @UniqueConstraint(columnNames = {"name", "initials"}))
public class FederativeUnit extends GenericEntity {

    @NotNull
    private String name;
    @NotNull
    private String initials;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "country")
    private Country country;
}