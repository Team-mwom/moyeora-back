package com.mwom.moyeora.database.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "TB_CATEGORY")
public class Category {
    @GeneratedValue
    @Id
    private Long categorySeq;

    @Column(nullable = false)
    private String categoryName;

    @Column(nullable = false)
    private String categoryClassYn;
}
