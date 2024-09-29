package com.mwom.moyeora.database.dto;

import lombok.Data;

@Data
public class MoyeoraInfoDto {

    private long myrInfoSeq;
    private long myrSeq;
    private String myrIntroduce;
    private String myrOwnerIntroduce;
    private String myrGenderYn;
    private String myrApprovalYn;
    private int myrMinAge;
    private int myrMaxAge;
    private String myrQuestion1;
    private String myrQuestion2;
    private String myrQuestion3;
    private String myrOwnerName;

}
