package com.mwom.moyeora.database.dto;

import com.mwom.moyeora.database.entity.MoyeoraEntity;
import lombok.Builder;
import lombok.Data;

@Data
public class MoyeoraDto {

    private long myrSeq;
    private long subCategorySeq;
    private String myrTitle;
    private String myrTags;
    private String myrMainImg;
    private int myrMaxMember;

}
