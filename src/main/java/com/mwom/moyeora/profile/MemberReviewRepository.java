package com.mwom.moyeora.profile;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberReviewRepository extends JpaRepository<MemberReviewEntity, Long> {

Page<MemberReviewEntity> findAll(Pageable pageable);
}