package com.mwom.moyeora.main.entity;

import com.mwom.common.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class MoyeoraPlace extends BaseEntity {

    @Id @GeneratedValue
    private int myrPlaceSeq; //모여라장소일련번호
    private int myrSeq; //모여라일련번호

    private int myrHardness; //경도
    private int myrLatitude; //위도
    private String myrplace; //장소

    public int getMyrPlaceSeq() {
        return myrPlaceSeq;
    }

    public void setMyrPlaceSeq(int myrPlaceSeq) {
        this.myrPlaceSeq = myrPlaceSeq;
    }

    public int getMyrSeq() {
        return myrSeq;
    }

    public void setMyrSeq(int myrSeq) {
        this.myrSeq = myrSeq;
    }

    public int getMyrHardness() {
        return myrHardness;
    }

    public void setMyrHardness(int myrHardness) {
        this.myrHardness = myrHardness;
    }

    public int getMyrLatitude() {
        return myrLatitude;
    }

    public void setMyrLatitude(int myrLatitude) {
        this.myrLatitude = myrLatitude;
    }

    public String getMyrplace() {
        return myrplace;
    }

    public void setMyrplace(String myrplace) {
        this.myrplace = myrplace;
    }
}
