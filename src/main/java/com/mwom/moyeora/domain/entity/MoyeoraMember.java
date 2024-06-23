package com.mwom.moyeora.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "TB_MOYEORA_MEMBER")
public class MoyeoraMember extends BaseEntity {
    @GeneratedValue
    @Id
    private Long myrMemberSeq;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MYR_SEQ")
    private Moyeora moyeora;

    private String myrApprovalCompleteYn;

    private String myrOpenYn;

    private String myrHostYn;

    private LocalDateTime myrAccessionDate;

    private LocalDateTime myrApprovalDate;

    private String myrAnswer1;
    private String myrAnswer2;
    private String myrAnswer3;
}
