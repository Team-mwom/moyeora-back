package com.mwom.moyeora.member;

import com.mwom.moyeora.member.jwt.TokenInfo;
import com.mwom.moyeora.member.sms.SMSService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

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

