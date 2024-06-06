package com.mwom.moyeora.profile;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@ResponseBody
@RequiredArgsConstructor
@RequestMapping("/api")
public class MemberReviewController {

  @Autowired
  private MemberReviewService memberReviewService;

  @GetMapping("/all/memberReviewList")
  public Page<MemberReviewEntity> memberReviewList(Pageable pageable)  {

    return memberReviewService.findAll(pageable);
  }

}

