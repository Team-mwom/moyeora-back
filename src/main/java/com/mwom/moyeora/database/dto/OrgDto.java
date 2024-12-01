package com.mwom.moyeora.database.dto;

import lombok.Data;

@Data
public class OrgDto {
    private String OrgCd; //지역코드  ex)6110000
    private String OrgNm; //지역명 ex)경기도
    private String UpOrgCd; //상위지역코드 ex)610000
    private String OrgClsCd; //지역클래스코드 ex) 1
    private String CdDelYn; //삭제여부 ex) Y
}
