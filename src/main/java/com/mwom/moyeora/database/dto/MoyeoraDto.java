package com.mwom.moyeora.database.dto;

import lombok.Data;

@Data
public class MoyeoraDto {

    private long myrSeq;
    private long subCategorySeq;
    private String myrTitle;
    private String myrTags;
    private String myrMainImg;
    private long myrMaxMember;
    private String categoryName,subCategoryName;

}
