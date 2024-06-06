package com.mwom.moyeora.profile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

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
@Table(name="TB_MEMBER_REVIEW")
public class MemberReviewEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "member_review_seq")
  private int memberReviewSeq;

  @Column(name = "member_seq")
  private int memberSeq;

  private int writer,star;


  private String content;



  @Column(nullable = true, length = 11)
  private int reg_id,mod_id;

  @Column(nullable = true, length = 20)
  private String reg_dt,mod_dt;




}
