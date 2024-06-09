package com.mwom.moyeora.profile;

import com.mwom.moyeora.member.MemberEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.transaction.Transactional;


@Data


public class MemberReviewDto {

private String ownerNickName;
private String writerNickName;
private String content;
private String date;
private int star;
private int totalPage;

}



