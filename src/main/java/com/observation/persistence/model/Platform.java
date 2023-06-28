package com.observation.persistence.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

@Audited @Entity @Data @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode(callSuper = false) @Table(uniqueConstraints = @UniqueConstraint(columnNames = {"telegraphicCallsign"}))
public class Platform extends GenericEntity {

	private String visualCallsign;
	private String telegraphicCallsign;
	private String internationalCallsign;
	private String name;
	private String internationalName;
//    private String imo;
//    private String navalCallsign;
//    private EnumTypeVessel type;
//    private Date since;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "country", nullable = false)
	private Country country;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "platformCategory")
	private PlatformCategory platformCategory;
}