package com.mwom.moyeora.database.entity;

import com.mwom.moyeora.database.entity.common.BaseEntity;
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
@DynamicInsert//insert시 null인값 무시 : DB에서 값이 없어도 자동 기본값 들어가는 애들한테 jpa가 null값을 넣을라하는거 막음
@DynamicUpdate
@Table(name="TB_MEMBER_REVIEW")
public class ReviewEntity extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "MEMBER_REVIEW_SEQ")
  private long memberReviewSeq;

  @Column(name = "MEMBER_SEQ")
  private long memberSeq;

  private long writer;

  private int star;


  private String content;





  @ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
  @JoinColumn(name = "member_seq", referencedColumnName = "member_seq", insertable = false, updatable = false)
  private MemberEntity memberOwnerEntity;//TB_MEMBER_REVIEW.member_seq -> TB_MEMBER.member_seq  //방명록 주인의 회원정보

  @ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
  @JoinColumn(name = "writer", referencedColumnName = "member_seq", insertable = false, updatable = false)
  private MemberEntity memberWriterEntity;//TB_MEMBER_REVIEW.writer -> TB_MEMBER.member_seq //방명록 작성자의 회원정보



}



