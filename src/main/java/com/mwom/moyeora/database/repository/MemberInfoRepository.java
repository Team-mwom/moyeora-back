package com.mwom.moyeora.database.repository;

import com.mwom.moyeora.database.entity.MemberEntity;
import com.mwom.moyeora.database.entity.MemberInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberInfoRepository extends JpaRepository<MemberEntity, Long> {

  public MemberInfoEntity save(MemberInfoEntity memberInfoEntity);


  public MemberEntity findTopByMemberSeq(int memberSeq);


}