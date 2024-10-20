package com.mwom.moyeora.database.vo;

import com.mwom.moyeora.database.entity.MoyeoraEntity;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
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
    private String myrPlace;
    private int myrMemberCnt;
    private int myrMaxMember;
    private LocalDateTime myrDate;
    private long regId;
    private LocalDateTime regDt;
    private long modId;
    private LocalDateTime modDt;

    public MoyeoraVo(MoyeoraEntity moyeora) {
        myrSeq = moyeora.getMyrSeq();
        categorySeq = moyeora.getSubCategoryEntity().getCategoryEntity().getCategorySeq();
        categoryName = moyeora.getSubCategoryEntity().getCategoryEntity().getCategoryName();
        subCategorySeq = moyeora.getSubCategoryEntity().getSubCategorySeq();
        subCategoryName = moyeora.getSubCategoryEntity().getSubCategoryName();
        myrTitle = moyeora.getMyrTitle();
        myrTags = moyeora.getMyrTags();
        myrMainImg = moyeora.getMyrMainImg();
        myrPlace = moyeora.getMoyeoraPlace().getMyrPlace();
        myrMemberCnt = moyeora.getMoyeoraMembers().size();
        myrMaxMember = moyeora.getMyrMaxMember();
        myrDate = moyeora.getMyrDate();
        regId = moyeora.getRegId();
        regDt = moyeora.getRegDt();
        modId = moyeora.getModId();
        modDt = moyeora.getModDt();
    }
}
