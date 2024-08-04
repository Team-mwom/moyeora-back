package com.mwom.moyeora.database.entity;

import com.mwom.moyeora.database.entity.common.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "TB_MOYEORA_MEMBER")
public class MoyeoraMember extends BaseEntity {

    @Id @GeneratedValue
    private Long myrMemberSeq; // 모여라 멤버 일련번호

    // 모여라(TB_MOYEORA)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MYR_SEQ")
    private Moyeora moyeora;

    private String myrApprovalCompleteYn; //가입승인여부

    private String myrOpenYn; //공개여부

    private String myrHostYn; //호스트

    private LocalDateTime myrAccesstionDate; //가입일

    private LocalDateTime myrApprovalDate; //신청일

    private String myrAnswer1; //답변1
    private String myrAnswer2; //답변2
    private String myrAnswer3; //답변3
}
