package com.mwom.moyeora.member;

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
@Table(name="TB_MEMBER")
public class MemberEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)//프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
  private int member_seq;

  @Column(nullable = true, length = 50)
  private String role,name,nickName,email;

  @Column(nullable = true, length = 20)
  private String kakao;

  @Column(nullable = true, length = 11)
  private int reg_id,mod_id;

  @Column(nullable = true, length = 20)

  private String reg_dt,mod_dt;
}
