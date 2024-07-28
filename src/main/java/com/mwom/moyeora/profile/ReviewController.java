package com.mwom.moyeora.profile;

import com.mwom.moyeora.member.MemberRepository;
import com.mwom.moyeora.member.MemberSeq;
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
    int writerSeq = Integer.parseInt(MemberSeq.getCurrentMemberSeq()) ;
    int ownerSeq = memberRepository.findTopByNickName(memberReviewDto.getOwnerNickName()).getMemberSeq();
    ReviewEntity memberReviewEntity = new ReviewEntity();
    memberReviewEntity.setMemberSeq(ownerSeq);
    memberReviewEntity.setWriter(writerSeq);
    memberReviewEntity.setContent(memberReviewDto.getContent());
    memberReviewEntity.setStar(memberReviewDto.getStar());
    memberReviewService.save(memberReviewEntity);
    return "success";
  }

}

