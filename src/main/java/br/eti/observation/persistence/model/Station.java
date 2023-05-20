package br.eti.observation.persistence.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import java.time.LocalDateTime;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Audited @Entity @Data @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode(callSuper = false)
public class Station extends GenericEntity {

    private Double localDepth;
    private LocalDateTime activation;
    private Double latitude;
    private Double longitude;
    private Integer marsdenSquare;
    private Integer marsdenSubSquare_1;
    private Integer wmoSquare;
    private Integer marsdenSubSquare_5;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "stationCategory")
    private StationCategory stationCategory;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "equipment")
    private Equipment equipment;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "surveying")
    private Surveying surveying;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "responsible")
    private Institution responsible;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "country")
    private Country country;
}