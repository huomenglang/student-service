package com.menglang.student.model.audit;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public abstract class AuditEntity<T extends Serializable> extends BaseEntity<T> {

    @Column(name = "created_at",nullable = false, updatable = false)
    @CreatedDate
    @DateTimeFormat
    private LocalDateTime createdAt;

    @Column(name = "created_by",nullable = false, updatable = false)
    @CreatedBy
    private String createdBy;

    @Column(name = "updated_at",insertable = false)
    @LastModifiedDate
    @DateTimeFormat
    protected LocalDateTime updatedAt;

    @Column(name = "updated_by",insertable = false)
    @LastModifiedBy
    private String updatedBy;



}
