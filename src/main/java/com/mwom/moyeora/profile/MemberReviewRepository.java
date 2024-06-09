package com.mwom.moyeora.profile;

import com.mwom.moyeora.member.MemberEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberReviewRepository extends JpaRepository<MemberReviewEntity, Long> {

  Page<MemberReviewEntity> findByMemberOwnerEntityNickNameOrderByRegDtDesc(Pageable pageable,String nickName); //방명록 주인의 닉네임으로 검색

  public MemberReviewEntity save(MemberReviewEntity memberReviewEntity);
}