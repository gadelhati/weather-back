package br.eti.observation.persistence.model;

import br.eti.observation.exception.enumeration.EGender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;
//import org.hibernate.validator.constraints.br.CPF;

@Audited @Entity @Data @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode(callSuper = false) @Table(uniqueConstraints = @UniqueConstraint(columnNames = {"cpf"}))
public class Individual extends Person {
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private EGender gender;
//    @CPF
    private String cpf;
}
