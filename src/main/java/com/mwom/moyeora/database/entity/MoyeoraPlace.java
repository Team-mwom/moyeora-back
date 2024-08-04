package com.mwom.moyeora.database.entity;

import com.mwom.moyeora.database.entity.common.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "TB_MOYEORA_PLACE")
public class MoyeoraPlace extends BaseEntity {

    @Id @GeneratedValue
    private Long myrPlaceSeq; //모여라장소일련번호

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "MYR_SEQ")
    private Moyeora moyeora;

    @Column(nullable = false)
    private String myrLongitude; // 경도

    @Column(nullable = false)
    private String myrLatitude; // 위도

    @Column(nullable = false)
    private String myrPlace; // 장소
}
