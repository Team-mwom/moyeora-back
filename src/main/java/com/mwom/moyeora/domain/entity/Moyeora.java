package com.mwom.moyeora.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "TB_MOYEORA")
public class Moyeora extends AuditingFields {
    @GeneratedValue
    @Id
    private Long myrSeq;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SUB_CATEGORY_SEQ")
    private SubCategory subCategory;

    @Column(nullable = false)
    private String myrTitle;

    private String myrTags;

    private String myrMainImg;

    private int myrMaxMember;

    private LocalDateTime myrDate;
}
