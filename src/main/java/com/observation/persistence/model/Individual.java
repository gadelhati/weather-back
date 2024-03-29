package com.observation.persistence.model;

import com.observation.persistence.enumeration.EGender;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

@Audited @Entity @Data @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode(callSuper = false)
public class Individual extends Person {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private EGender gender;
    private String cpf;
}
