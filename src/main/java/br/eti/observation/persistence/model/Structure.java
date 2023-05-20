package br.eti.observation.persistence.model;

import br.eti.observation.persistence.model.enumeration.EnumFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

@Audited @Entity @Data @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode(callSuper = false)
@Inheritance(strategy = InheritanceType.JOINED)
public class Structure extends GenericEntity {
    private float altitude;
    private float height;
    private float calado;//sem tradução conhecida
    private float circuloDeGiro;//sem tradução conhecida
    private String color;
    private String buildingMaterial;
    private String name;
    private String number;
    private boolean placaDeVisibilidade;//sem tradução conhecida
    private boolean refletorRadar;//sem tradução conhecida
    private boolean visivelmenteConspicuo;//sem tradução conhecida
    private EnumFormat format;
    private Radar radar;
}