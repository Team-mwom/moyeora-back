package com.mwom.moyeora.database.entity;

import com.mwom.moyeora.database.dto.MoyeoraInfoDto;
import com.mwom.moyeora.database.dto.MoyeoraPlaceDto;
import com.mwom.moyeora.database.entity.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Getter
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Builder
@Table(name = "TB_MOYEORA_PLACE")
public class MoyeoraPlaceEntity extends BaseEntity {

    @Id @GeneratedValue
    private Long myrPlaceSeq; //모여라장소일련번호

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "MYR_SEQ")
    private MoyeoraEntity moyeora;

//    @Column(nullable = false)
//    private Long myrSeq;

    @Column(nullable = false)
    private String myrAddressNumber;

    @Column(nullable = false)
    private String myrAddressLocation;

    @Column(nullable = false)
    private Long myrLongitude; // 경도

    @Column(nullable = false)
    private Long myrLatitude; // 위도

    @Column(nullable = false)
    private String myrPlace; // 장소

    @Column(nullable = false)
    private String myrSido;

    @Column(nullable = false)
    private String myrSigungu;

    public static MoyeoraPlaceEntity toEntity(MoyeoraPlaceDto moyeoraPlaceDto) {
        return MoyeoraPlaceEntity.builder()
                .myrPlaceSeq(moyeoraPlaceDto.getMyrPlaceSeq())
//                .myrSeq(moyeoraPlaceDto.getMyrSeq())
                .myrAddressNumber(moyeoraPlaceDto.getMyrAddressNumber())
                .myrAddressLocation(moyeoraPlaceDto.getMyrAddressLocation())
                .myrPlace(moyeoraPlaceDto.getMyrPlace())
                .myrLongitude(moyeoraPlaceDto.getMyrLongitude())
                .myrLatitude(moyeoraPlaceDto.getMyrLongitude())
                .myrSido(moyeoraPlaceDto.getMyrSido())
                .myrSigungu(moyeoraPlaceDto.getMyrSigungu())
                .build();
    }

}
