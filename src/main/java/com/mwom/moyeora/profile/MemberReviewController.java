package com.mwom.moyeora.profile;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@ResponseBody
@RequiredArgsConstructor
@RequestMapping("/api")
public class MemberReviewController {

  @Autowired
  private MemberReviewService memberReviewService;

  @GetMapping("/all/memberReviewList")
  public  List<MemberReviewDto> memberReviewList(@Param("nickName")String nickName, Pageable pageable)  {
    System.out.println("nickName = " + nickName);


    return memberReviewService.getReviewList(pageable,nickName);
  }

}

