package com.mwom.moyeora.database.entity;

import com.mwom.moyeora.database.dto.MoyeoraInfoDto;
import com.mwom.moyeora.database.dto.MoyeoraPlaceDto;
import com.mwom.moyeora.database.entity.common.BaseEntity;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Getter
@Setter
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Builder
@DynamicInsert
@Table(name = "TB_MOYEORA_PLACE")
public class MoyeoraPlaceEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
    @Column(name = "MYR_PLACE_SEQ", nullable = true, length = 11)
    private Long myrPlaceSeq; // 모여라장소일련번호

    // @OneToOne(fetch = LAZY)
    // @JoinColumn(name = "MYR_SEQ")
    // private MoyeoraEntity moyeora;

    @Column(name = "MYR_SEQ", nullable = true, length = 11)
    private Long myrSeq;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "MYR_SEQ", referencedColumnName = "MYR_SEQ", insertable = false, updatable = false)
    private MoyeoraEntity moyeoraEntity;

    @Column(name = "MYR_ADDRESS_NUMBER", nullable = false)
    private String myrAddressNumber;

    @Column(name = "MYR_ADDRESS_LOCATION", nullable = false)
    private String myrAddressLocation;

    @Column(name = "MYR_LONGITUDE", nullable = false)
    private Long myrLongitude; // 경도

    @Column(name = "MYR_LATITUDE", nullable = false)
    private Long myrLatitude; // 위도

    @Column(name = "MYR_PLACE", nullable = false)
    private String myrPlace; // 장소

    @Column(name = "MYR_SIDO", nullable = false)
    private String myrSido;

    @Column(name = "MYR_SIGUNGU", nullable = false)
    private String myrSigungu;

    public static MoyeoraPlaceEntity toEntity(MoyeoraPlaceDto moyeoraPlaceDto) {
        return MoyeoraPlaceEntity.builder()
                .myrPlaceSeq(moyeoraPlaceDto.getMyrPlaceSeq())
                .myrSeq(moyeoraPlaceDto.getMyrSeq())
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
