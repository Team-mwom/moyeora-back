package com.mwom.moyeora.test.controller;

import com.mwom.moyeora.test.jwt.MemberLoginRequestDto;
import com.mwom.moyeora.test.jwt.MemberService;
import com.mwom.moyeora.test.jwt.TokenInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@ResponseBody
@RequiredArgsConstructor
@RequestMapping("/api")
public class TestJwtController {

  private final MemberService memberService;

  @PostMapping("/login")
  public TokenInfo login(@RequestBody MemberLoginRequestDto memberLoginRequestDto) {

    String memberId = memberLoginRequestDto.getMemberId();
    String password = memberLoginRequestDto.getPassword();
    TokenInfo tokenInfo = memberService.login(memberId, password);


    return tokenInfo;
  }




//  @PostMapping("/signIn")
//  public void signIn(@RequestBody SignInDto signInDto) {
//
//    System.out.println(signInDto);
//  }
  @PostMapping("/isSingnIn")
  public String test() {
    return "success";
  }

}
