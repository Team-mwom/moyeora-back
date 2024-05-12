package com.mwom.moyeora.main.entity;

import com.mwom.common.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SubCategory extends BaseEntity {

    @Id @GeneratedValue
    private int subCategorySeq;

    private int categorySeq; //카테고리일련번호
    private String subCategoryName; //카테고리이름
    private String categoryClassYn; //주제소주제여부

    public int getSubCategorySeq() {
        return subCategorySeq;
    }

    public void setSubCategorySeq(int subCategorySeq) {
        this.subCategorySeq = subCategorySeq;
    }

    public int getCategorySeq() {
        return categorySeq;
    }

    public void setCategorySeq(int categorySeq) {
        this.categorySeq = categorySeq;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    public String getCategoryClassYn() {
        return categoryClassYn;
    }

    public void setCategoryClassYn(String categoryClassYn) {
        this.categoryClassYn = categoryClassYn;
    }
}
