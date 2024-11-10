package com.mwom.moyeora.database.entity;

import com.mwom.moyeora.database.entity.common.BaseEntity;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Data
@NoArgsConstructor
@DynamicInsert//insert시 null인값 무시 : DB에서 값이 없어도 자동 기본값 들어가는 애들한테 jpa가 null값을 넣을라하는거 막음
@DynamicUpdate
@Entity
@AllArgsConstructor
@Builder
@Table(name = "TB_SUB_CATEGORY")
public class SubCategoryEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SUB_CATEGORY_SEQ")
    private Long subCategorySeq; // 카테고리 일련번호

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEGORY_SEQ")
    private CategoryEntity categoryEntity;

    @Column(nullable = false)
    private String subCategoryName; //카테고리 이름

    @Column(nullable = false)
    private String categoryClassYn; //주제 소주제 여부

}
