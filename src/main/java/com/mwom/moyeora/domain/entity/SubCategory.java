package com.mwom.moyeora.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "TB_SUB_CATEGORY")
public class SubCategory {
    @GeneratedValue
    @Id
    private Long subCategorySeq;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEGORY_SEQ")
    private Category category;

    @Column(nullable = false)
    private String subCategoryName;

    @Column(nullable = false)
    private String categoryClassYn;
}
