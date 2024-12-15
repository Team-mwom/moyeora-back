package com.mwom.moyeora.database.entity;

import com.mwom.moyeora.database.dto.MoyeoraDto;
import com.mwom.moyeora.database.dto.MoyeoraInfoDto;
import com.mwom.moyeora.database.entity.common.BaseEntity;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Builder
@DynamicInsert
@Table(name = "TB_MOYEORA_INFO")
public class MoyeoraInfoEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
    @Column(name = "MYR_INFO_SEQ", nullable = true, length = 11)
    private Long myrInfoSeq;

    @Column(name = "MYR_SEQ", nullable = true, length = 11)
    private Long myrSeq;

    @Column(name = "MYR_INTRODUCE", nullable = true)
    private String myrIntroduce;

    @Column(name = "MYR_OWNER_INTRODUCE")
    private String myrOwnerIntroduce;

    @Column(name = "MYR_GENDER_YN", nullable = true, length = 1)
    private String myrGenderYn;

    @Column(name = "MYR_APPROVAL_YN", nullable = true, length = 1)
    private String myrApprovalYn;

    @Column(name = "MYR_MIN_AGE", nullable = true, length = 3)
    private int myrMinAge;

    @Column(name = "MYR_MAX_AGE", nullable = true, length = 3)
    private int myrMaxAge;

    @Column(name = "MYR_QUESTION1")
    private String myrQuestion1;

    @Column(name = "MYR_QUESTION2")
    private String myrQuestion2;

    @Column(name = "MYR_QUESTION3")
    private String myrQuestion3;

    @Column(name = "MYR_OWNER_NAME")
    private String myrOwnerName;

    public static MoyeoraInfoEntity toEntity(MoyeoraInfoDto moyeoraInfoDto) {
        return MoyeoraInfoEntity.builder()
                .myrInfoSeq(moyeoraInfoDto.getMyrInfoSeq())
                .myrSeq(moyeoraInfoDto.getMyrSeq())
                .myrIntroduce(moyeoraInfoDto.getMyrIntroduce())
                .myrOwnerIntroduce(moyeoraInfoDto.getMyrOwnerIntroduce())
                .myrGenderYn(moyeoraInfoDto.getMyrGenderYn())
                .myrApprovalYn(moyeoraInfoDto.getMyrApprovalYn())
                .myrMinAge(moyeoraInfoDto.getMyrMinAge())
                .myrMaxAge(moyeoraInfoDto.getMyrMaxAge())
                .myrQuestion1(moyeoraInfoDto.getMyrQuestion1())
                .myrQuestion2(moyeoraInfoDto.getMyrQuestion2())
                .myrQuestion3(moyeoraInfoDto.getMyrQuestion3())
                .myrOwnerName(moyeoraInfoDto.getMyrOwnerName())
                .build();
    }
}
