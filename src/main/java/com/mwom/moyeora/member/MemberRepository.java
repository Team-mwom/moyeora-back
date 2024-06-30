package com.mwom.moyeora.member;

import com.mwom.moyeora.member.MemberEntity;
import com.mwom.moyeora.test.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
  Optional<MemberEntity> findByKakao(String kakao);

 MemberEntity findTopByMemberSeq(int member_seq);

  public MemberEntity save(MemberEntity memberEntity);


  @Query(value = "update TB_MEMBER set REFRESH_TOKEN = :#{#entity.refreshToken} where KAKAO = :#{#entity.kakao}",nativeQuery = true)
  public void updateMemberEntity(@Param("entity") MemberEntity memberEntity);

  MemberEntity findTopByRefreshToken(String refreshToken);

  MemberEntity findTopByNickName(String nickName);

}