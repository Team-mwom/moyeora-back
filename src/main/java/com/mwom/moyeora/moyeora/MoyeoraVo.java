package com.mwom.moyeora.moyeora;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MoyeoraVo {
    private int myrSeq;
    private int categorySeq;
    private String categoryName;
    private int subCategorySeq;
    private String subCategoryName;
    private String myrTitle;
    private String myrTags;
    private String myrMainImg;
    private int myrMaxMember;
    private LocalDateTime myrDate;
    private int regId;
    private LocalDateTime regDt;
    private int modId;
    private LocalDateTime modDt;
}
