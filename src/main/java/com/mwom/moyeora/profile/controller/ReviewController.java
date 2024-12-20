package com.mwom.moyeora.profile.controller;

import com.mwom.moyeora.database.repository.MemberRepository;
import com.mwom.moyeora.common.MemberSeq;
import com.mwom.moyeora.database.dto.ReviewDto;
import com.mwom.moyeora.database.entity.ReviewEntity;
import com.mwom.moyeora.profile.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@ResponseBody
@RequiredArgsConstructor
@RequestMapping("/api")
public class ReviewController {

  @Autowired
  private ReviewService memberReviewService;
  @Autowired
  MemberRepository memberRepository;

  @GetMapping("/all/memberReviewList")
  public  List<ReviewDto> memberReviewList(@Param("nickName")String nickName, Pageable pageable)  {
    System.out.println("nickName = " + nickName);


    return memberReviewService.getReviewList(pageable,nickName);
  }

  @PostMapping("/user/insertReview")
  public String insertReview(@RequestBody ReviewDto memberReviewDto){
    long writerSeq =MemberSeq.getCurrentMemberSeq();
    long ownerSeq = memberRepository.findTopByNickName(memberReviewDto.getOwnerNickName()).getMemberSeq();
    ReviewEntity memberReviewEntity = new ReviewEntity();
    memberReviewEntity.setMemberSeq(ownerSeq);
    memberReviewEntity.setWriter(writerSeq);
    memberReviewEntity.setContent(memberReviewDto.getContent());
    memberReviewEntity.setStar(memberReviewDto.getStar());
    memberReviewEntity.setModId(writerSeq);
    memberReviewEntity.setRegId(writerSeq);
    memberReviewService.save(memberReviewEntity);
    return "success";
  }

}

