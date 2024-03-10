package com.mwom.moyeora.member;

import com.mwom.moyeora.member.jwt.TokenInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Slf4j
@RestController
@ResponseBody
@RequiredArgsConstructor
@RequestMapping("/api")
public class SignInController {

  @Autowired
  private SignInService signInService;

  @Autowired
  private KakaoService kakaoService;



  @GetMapping("/all/signIn")
  public TokenInfo signIn(@Param("code") String code) throws IOException {
    String kakaoId = kakaoService.getKaKaoAccessToken(code);

    return signInService.login(kakaoId);
  }
  @PostMapping("/admin/isAdmin")
  public String isAdmin() {
    return "success";
  }
  @PostMapping("/user/isUser")
  public String isUser() {
    return "success";
  }

}
