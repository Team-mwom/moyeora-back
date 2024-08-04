package com.mwom.moyeora.database.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public abstract class BaseEntity {
//    @CreatedBy
    @Column(nullable = false, updatable = false)
    private String regId;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime regDt;

//    @LastModifiedBy
    private String modId;

    @LastModifiedDate
    protected LocalDateTime modDt;
}
