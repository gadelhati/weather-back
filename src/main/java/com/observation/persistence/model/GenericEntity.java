package com.observation.persistence.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data @MappedSuperclass @EqualsAndHashCode(callSuper = false)
public abstract class GenericEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "UUID", strategy = GenerationType.AUTO)
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", unique = true, nullable = false)
    private UUID id;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
//    @CreatedDate
//    private Date createdOn;
//    @LastModifiedDate
//    private Date modifiedOn;
//    @CreatedBy
//    private String createdBy;
//    @LastModifiedBy
//    private String modifiedBy;
    @PrePersist
    public void prePersist() { createdAt = LocalDateTime.now();}
    @PostUpdate
    public void postUpdate() { updatedAt = LocalDateTime.now();}
    @PreRemove
    public void preRemove() { }
}