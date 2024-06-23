package com.mwom.moyeora.moyeora;

import com.mwom.moyeora.domain.entity.Moyeora;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MoyeoraVo {
    private Long myrSeq;
    private Long categorySeq;
    private String categoryName;
    private Long subCategorySeq;
    private String subCategoryName;
    private String myrTitle;
    private String myrTags;
    private String myrMainImg;
    private int myrMaxMember;
    private LocalDateTime myrDate;
    private String regId;
    private LocalDateTime regDt;
    private String modId;
    private LocalDateTime modDt;

    public MoyeoraVo(Moyeora moyeora) {
        myrSeq = moyeora.getMyrSeq();
        categorySeq = moyeora.getSubCategory().getCategory().getCategorySeq();
        categoryName = moyeora.getSubCategory().getCategory().getCategoryName();
        subCategorySeq = moyeora.getSubCategory().getSubCategorySeq();
        subCategoryName = moyeora.getSubCategory().getSubCategoryName();
        myrTitle = moyeora.getMyrTitle();
        myrTags = moyeora.getMyrTags();
        myrMainImg = moyeora.getMyrMainImg();
        myrMaxMember = moyeora.getMyrMaxMember();
        myrDate = moyeora.getMyrDate();
        regId = moyeora.getRegId();
        regDt = moyeora.getRegDt();
        modId = moyeora.getModId();
        modDt = moyeora.getModDt();
    }
}
