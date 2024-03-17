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
public class SignController {

  @Autowired
  private SignInService signInService;
  @Autowired
  private  SignUpService signUpService;

  @Autowired
  private KakaoService kakaoService;




  @GetMapping("/all/kakaoToken")
  public String kakaoToken(@Param("code") String code) throws IOException {
    return  kakaoService.getKaKaoAccessToken(code);
  }
  @GetMapping("/all/signIn")
  public TokenInfo signIn(@Param("kakaoId") String kakaoId) throws IOException {

    return signInService.signIn(kakaoId);
  }


  @PostMapping("/admin/isAdmin")
  public String isAdmin() {
    return "success";
  }
  @PostMapping("/user/isUser")
  public String isUser() {
    return "success";
  }

  @PostMapping("all/signup")
  public String signUp(@RequestBody MemberEntity memberEntity){
    signUpService.signUp(memberEntity);
    return "success";
  }

}
