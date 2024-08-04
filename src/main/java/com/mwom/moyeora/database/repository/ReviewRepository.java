package com.mwom.moyeora.database.repository;

import com.mwom.moyeora.database.entity.ReviewEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {

  Page<ReviewEntity> findByMemberOwnerEntityNickNameOrderByRegDtDesc(Pageable pageable, String nickName); //방명록 주인의 닉네임으로 검색

  public ReviewEntity save(ReviewEntity memberReviewEntity);
}