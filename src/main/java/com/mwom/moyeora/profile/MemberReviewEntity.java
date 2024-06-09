package com.mwom.moyeora.profile;

import com.mwom.moyeora.member.MemberEntity;
import com.mwom.moyeora.member.MemberInfoEntity;
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



  @Column(name = "reg_id")
  private int regId;
  @Column(name = "mod_id")
  private int modId;

  @Column(name = "reg_dt")
  private String regDt;
  @Column(name = "mod_dt")
  private String modDt;

  @ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
  @JoinColumn(name = "member_seq", referencedColumnName = "member_seq", insertable = false, updatable = false)
  private MemberEntity memberOwnerEntity;//TB_MEMBER_REVIEW.member_seq -> TB_MEMBER.member_seq  //방명록 주인의 회원정보

  @ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
  @JoinColumn(name = "writer", referencedColumnName = "member_seq", insertable = false, updatable = false)
  private MemberEntity memberWriterEntity;//TB_MEMBER_REVIEW.writer -> TB_MEMBER.member_seq //방명록 작성자의 회원정보



}



