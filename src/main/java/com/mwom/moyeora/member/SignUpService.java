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
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class SignUpService {

  @Autowired
  private MemberRepository memberRepository;


  @Transactional
  public void signUp(MemberEntity entity) {

    memberRepository.save(entity);


  }
}