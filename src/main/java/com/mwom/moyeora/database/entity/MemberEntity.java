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
@DynamicInsert // insert시 null인값 무시 : DB에서 값이 없어도 자동 기본값 들어가는 애들한테 jpa가 null값을 넣을라하 하는거 막음
@DynamicUpdate
@Table(name = "TB_MEMBER")
public class MemberEntity extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "MEMBER_SEQ")
  private long memberSeq;

  @Column(nullable = true, length = 50)
  private String role, name, nickName, email;

  @Column(nullable = true, length = 50)
  private String kakao;

  @Column(name = "REFRESH_TOKEN")
  private String refreshToken;

  @OneToOne(mappedBy = "memberEntity")
  private MemberInfoEntity memberInfoEntity;

}
