package br.eti.observation.persistence.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

@Audited @Entity @Data @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode(callSuper = false)
public class Component extends GenericEntity {

    private String name;
    private String j1;
    private String k1;
    private String k2;
    private String l2;
    private String m1;
    private String m2;
    private String n2;
    private String o1;
    private String p1;
    private String q1;
    private String s1;
    private String s2;
    private String t2;
    private String v2;
    private String type;
    private String velocity;
}