package com.mwom.moyeora.database.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Getter
@NoArgsConstructor
@Entity
@Table(name = "TB_SUB_CATEGORY")
public class SubCategoryEntity {
    @GeneratedValue
    @Id
    private Long subCategorySeq; // 카테고리 일련번호

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEGORY_SEQ")
    private CategoryEntity categoryEntity;

    @Column(nullable = false)
    private String subCategoryName; //카테고리 이름

    @Column(nullable = false)
    private String categoryClassYn; //주제 소주제 여부
}
