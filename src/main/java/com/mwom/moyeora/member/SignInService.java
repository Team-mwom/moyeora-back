package com.mwom.moyeora.member;

import com.mwom.moyeora.member.jwt.JwtTokenProvider;
import com.mwom.moyeora.member.jwt.TokenInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SignInService {

 
  private final AuthenticationManagerBuilder authenticationManagerBuilder;
  private final JwtTokenProvider jwtTokenProvider;

  @Autowired
  private  final MemberRepository memberRepository;
  @Transactional
  public TokenInfo signIn(String kakaoId) {

      // 1. Login ID/PW 를 기반으로 Authentication 객체 생성
      // 이때 authentication 는 인증 여부를 확인하는 authenticated 값이 false
      UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(kakaoId,kakaoId);
    // 2. 실제 검증 (사용자 비밀번호 체크)이 이루어지는 부분
    // authenticate 매서드가 실행될 때 CustomUserDetailsService 에서 만든 loadUserByUsername 메서드가 실행
    Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

    // 3. 인증 정보를 기반으로 JWT 토큰 생성
    TokenInfo tokenInfo = jwtTokenProvider.generateToken(authentication);


  return tokenInfo;

  }


  @Transactional
  public void updateRefreshToken(MemberEntity memberEntity){
    memberRepository.updateMemberEntity(memberEntity);
  }

  @Transactional
  public TokenInfo reissue(String refreshToken){
    String kakaoId = memberRepository.findTopByRefreshToken(refreshToken).getKakao();
    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(kakaoId,kakaoId);
    // 2. 실제 검증 (사용자 비밀번호 체크)이 이루어지는 부분
    // authenticate 매서드가 실행될 때 CustomUserDetailsService 에서 만든 loadUserByUsername 메서드가 실행
    Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

    // 3. 인증 정보를 기반으로 JWT 토큰 생성
    TokenInfo tokenInfo = jwtTokenProvider.generateToken(authentication,refreshToken);


    return tokenInfo;

  }

  @Transactional
  public MemberEntity selectMemberInfo (String member_seq){

    return memberRepository.findTopByMemberSeq(Integer.parseInt(member_seq));

  }



}