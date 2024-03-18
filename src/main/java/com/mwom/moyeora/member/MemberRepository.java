package com.mwom.moyeora.member;

import com.mwom.moyeora.member.MemberEntity;
import com.mwom.moyeora.test.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
  Optional<MemberEntity> findByKakao(String kakao);
  public MemberEntity save(MemberEntity entity);
}