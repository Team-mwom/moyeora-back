package com.mwom.moyeora.main.entity;

import com.mwom.common.BaseEntity;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
@NoArgsConstructor
@Entity
@Table(name = "TB_MOYEORA")
public class Moyeora extends BaseEntity {

    @Id @GeneratedValue
    private int myrSeq;
    private int subCategorySeq;

    private String myrTitle; //제목
    private String myrTags; //태그
    private String myrMainImg; //메인이미지
    private int myrMaxMember; //최대인원수
    private LocalDateTime myrDate; //모임날

    @ManyToOne
    @JoinColumn(name = "SUB_CATEGORY_SEQ")
    private SubCategory subCategory; //카테고리

    @OneToOne
    @JoinColumn(name = "MYR_PLACE_SEQ")
    private MoyeoraPlace moyeoraPlcae; //모여라 장소

    @OneToMany


    public int getMyrSeq() {
        return myrSeq;
    }

    public void setMyrSeq(int myrSeq) {
        this.myrSeq = myrSeq;
    }

    public int getSubCategorySeq() {
        return subCategorySeq;
    }

    public void setSubCategorySeq(int subCategorySeq) {
        this.subCategorySeq = subCategorySeq;
    }

    public String getMyrTitle() {
        return myrTitle;
    }

    public void setMyrTitle(String myrTitle) {
        this.myrTitle = myrTitle;
    }

    public String getMyrTags() {
        return myrTags;
    }

    public void setMyrTags(String myrTags) {
        this.myrTags = myrTags;
    }

    public String getMyrMainImg() {
        return myrMainImg;
    }

    public void setMyrMainImg(String myrMainImg) {
        this.myrMainImg = myrMainImg;
    }

    public int getMyrMaxMember() {
        return myrMaxMember;
    }

    public void setMyrMaxMember(int myrMaxMember) {
        this.myrMaxMember = myrMaxMember;
    }

    public LocalDateTime getMyrDate() {
        return myrDate;
    }

    public void setMyrDate(LocalDateTime myrDate) {
        this.myrDate = myrDate;
    }

    public SubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }
}
