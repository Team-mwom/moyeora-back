package com.mwom.moyeora.member;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MemberReviewRepository extends JpaRepository<MemberReviewEntity, Long> {

Page<MemberReviewEntity> findAll(Pageable pageable);
}