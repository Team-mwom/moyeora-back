package com.mwom.moyeora.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "TB_MOYEORA_PLACE")
public class MoyeoraPlace extends BaseEntity {
    @GeneratedValue
    @Id
    private Long myrPlaceSeq;

    @OneToOne
    @JoinColumn(name = "MYR_SEQ")
    private Moyeora moyeora;

    @Column(nullable = false)
    private String myrLongitude;

    @Column(nullable = false)
    private String myrLatitude;

    @Column(nullable = false)
    private String myrPlace;
}
