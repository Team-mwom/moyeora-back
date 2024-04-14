package com.mwom.moyeora.member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenerationTime;

import javax.annotation.Generated;
import javax.persistence.*;
import javax.transaction.Transactional;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Transactional
@DynamicInsert//insert시 null인값 무시 : DB에서 값이 없어도 자동 기본값 들어가는 애들한테 jpa가 null값을 넣을라하 하는거 막음
@DynamicUpdate
@Table(name="TB_MEMBER_INFO")
public class MemberInfoEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)//프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
  @Column(name = "MEMBER_INFO_SEQ")
  private int memberInfoSeq;


  @Column(name = "member_seq")
  private int memberSeq;

  @Column(name = "ADDRESS_NUM")
  private String addressNum;

  @Column(name = "ADDRESS_LOCATION")
  private String addressLocation;

  @Column(name = "ADDRESS_DETAIL")
  private String addressDetail;

  @Column(name = "PHONE_FIRST")
  private String phoneFirst;

  @Column(name = "PHONE_MIDDLE")
  private String phoneMiddle;

  @Column(name = "PHONE_LAST")
  private String phoneLast;

  private String about;

  @Column(name = "PROFILE_IMG")
  private String profileImg;

  @Column(name = "PHONE_AUTH_YN")
  private String phoneAuthYN;

  private String gender;

  private int age;



}
