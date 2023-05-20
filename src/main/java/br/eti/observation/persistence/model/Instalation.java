package br.eti.observation.persistence.model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

@Audited @Entity @Data @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn(name="id")
public class Instalation extends Structure {
    private String orderNumber;
    private Maintainer maintainer;
}