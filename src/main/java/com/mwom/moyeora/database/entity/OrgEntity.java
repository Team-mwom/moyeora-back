package com.mwom.moyeora.database.entity;

import com.mwom.moyeora.database.dto.OrgDto;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Builder
@Table(name="TB_ORG")
public class OrgEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String orgCd;

    @Column(nullable = false)
    private String orgNm;

    @Column(nullable = false)
    private String upOrgCd;

    @Column(nullable = false)
    private String orgClsCd;

    @Column(nullable = false)
    private String cdDelYn;

    public static OrgEntity toEntity(OrgDto orgDto) {
        return OrgEntity.builder()
                .orgCd(orgDto.getOrgCd())
                .orgNm(orgDto.getOrgNm())
                .upOrgCd(orgDto.getUpOrgCd())
                .orgClsCd(orgDto.getOrgClsCd())
                .cdDelYn(orgDto.getCdDelYn())
                .build();
    }
}
