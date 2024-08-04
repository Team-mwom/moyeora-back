package com.mwom.moyeora.database.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "TB_MOYEORA")
public class Moyeora extends BaseEntity {

    @Id @GeneratedValue
    private Long myrSeq;

    //서브카테고리(TB_SUB_CATEGORY)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SUB_CATEGORY_SEQ")
    private SubCategory subCategory;

    //장소(TB_MOYEORA_PLACE)
    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "myr_seq")
    private MoyeoraPlace moyeoraPlace; //모여라 장소

    //가입(TB_MOYEORA_MEMBER)
    // 양방향
    @OneToMany(mappedBy = "moyeora")
    private List<MoyeoraMember> moyeoraMembers = new ArrayList<>();

    @Column(nullable = false)
    private String myrTitle; //제목

    private String myrTags; //태그

    private String myrMainImg; //메인이미지

    private int myrMaxMember; //최대인원수

    private LocalDateTime myrDate; //모임날
}
