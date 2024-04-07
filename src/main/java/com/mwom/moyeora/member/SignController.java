package com.mwom.moyeora.member;

import com.mwom.moyeora.member.jwt.TokenInfo;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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
  public String kakaoToken(@Param("code") String code) throws IOException {//카카오 아이디를 받기

    return kakaoService.getKaKaoAccessToken(code);
  }
  @GetMapping("/all/signIn")
  public TokenInfo signIn(@Param("kakaoId") String kakaoId) throws IOException {
    //카카오 아이디를 통해 jwt로 토큰을 생성하며 refreshToken은 db에 저장된다.
    TokenInfo tokenInfo =signInService.signIn(kakaoId);
    MemberEntity memberEntity = new MemberEntity();
    memberEntity.setKakao(kakaoId);
    memberEntity.setRefreshToken(tokenInfo.getRefreshToken());
    signInService.updateRefreshToken(memberEntity);


    return tokenInfo;
  }
  @PostMapping("/user/getMyInfo")
  public MemberEntity getMyInfo (){
    MemberEntity entity = signInService.selectMemberInfo(MemberSeq.getCurrentMemberSeq());
    entity.setMemberSeq(0);
    entity.setKakao(null);
    entity.setRefreshToken(null);
    return entity;
  }

  @PostMapping("/admin/isAdmin")
  public String isAdmin() {

    return "success";
  }
  @PostMapping("/user/isUser")
  public String isUser() {
    System.out.println(MemberSeq.getCurrentMemberSeq());
    return "success";

  }

  @PostMapping("all/signup")
  public String signUp(@RequestBody MemberEntity memberEntity){
    signUpService.signUp(memberEntity);


    return "success";
  }

  @GetMapping("all/refreshAccessToken")
  public TokenInfo refreshAccessToken (String refreshToken){
    System.out.println(refreshToken);

    return signInService.reissue(refreshToken);
  }

  @GetMapping("all/signUp/checkNickName")
  public boolean checkNickName(String nickName){

    return signUpService.checkNickName(nickName);
  }


}

