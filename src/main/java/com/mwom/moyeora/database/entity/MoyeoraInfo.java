package com.mwom.moyeora.database.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="TB_MOYEORA_INFO")
public class MoyeoraInfo extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
    @Column(name = "MRY_INFO_SEQ", nullable = true, length = 11)
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

    @Column(name = "MYR_PRICE", nullable = true, length = 64)
    private int myrPrice;

    @Column(name = "MYR_PRICE_INFO")
    private String myrPriceInfo;

    @Column(name = "MYR_QUESTION1")
    private String myrQusetion1;

    @Column(name = "MYR_QUESTION2")
    private String myrQusetion2;

    @Column(name = "MYR_QUESTION3")
    private String myrQusetion3;
}
