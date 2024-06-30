package com.mwom.moyeora.profile;

import lombok.Data;


@Data


public class ReviewDto {

private String ownerNickName;
private String writerNickName;
private String content;
private String date;
private int star;
private int totalPage;

}



