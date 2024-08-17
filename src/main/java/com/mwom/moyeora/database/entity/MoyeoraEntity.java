package com.mwom.moyeora.database.entity;

import com.mwom.moyeora.database.entity.common.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Data
@NoArgsConstructor
@DynamicInsert//insert시 null인값 무시 : DB에서 값이 없어도 자동 기본값 들어가는 애들한테 jpa가 null값을 넣을라하는거 막음
@DynamicUpdate
@Entity
@Table(name = "TB_MOYEORA")
public class MoyeoraEntity extends BaseEntity {

    @Id @GeneratedValue
    private Long myrSeq;

    //서브카테고리(TB_SUB_CATEGORY)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SUB_CATEGORY_SEQ")
    private SubCategoryEntity subCategory;

    //장소(TB_MOYEORA_PLACE)
    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "myr_seq")
    private MoyeoraPlaceEntity moyeoraPlace; //모여라 장소

    //가입(TB_MOYEORA_MEMBER)
    // 양방향
    @OneToMany(mappedBy = "moyeora")
    private List<MoyeoraMemberEntity> moyeoraMembers = new ArrayList<>();

    @Column(nullable = false)
    private String myrTitle; //제목

    private String myrTags; //태그

    private String myrMainImg; //메인이미지

    private int myrMaxMember; //최대인원수

    private LocalDateTime myrDate; //모임날
}
