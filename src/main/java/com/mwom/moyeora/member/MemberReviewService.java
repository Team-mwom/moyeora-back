package com.mwom.moyeora.member;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberReviewService {

  @Autowired
  private MemberReviewRepository memberReviewRepository;

  Page<MemberReviewEntity> findAll(Pageable pageable){
    return memberReviewRepository.findAll(pageable);
  }

}