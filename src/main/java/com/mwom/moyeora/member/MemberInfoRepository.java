package com.mwom.moyeora.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MemberInfoRepository extends JpaRepository<MemberEntity, Long> {

  public MemberInfoEntity save(MemberInfoEntity memberInfoEntity);


  public MemberEntity findTopByMemberSeq(int memberSeq);


}