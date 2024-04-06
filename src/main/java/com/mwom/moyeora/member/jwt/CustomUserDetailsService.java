package com.mwom.moyeora.member.jwt;

import com.mwom.moyeora.member.MemberEntity;
import com.mwom.moyeora.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

  private final MemberRepository memberRepository;
  private final PasswordEncoder passwordEncoder;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    return memberRepository.findByKakao(username)
      .map(this::createUserDetails)
      .orElseThrow(() -> new UsernameNotFoundException("해당하는 유저를 찾을 수 없습니다."));
  }

  // 해당하는 User 의 데이터가 존재한다면 UserDetails 객체로 만들어서 리턴
  private UserDetails createUserDetails(MemberEntity member) {
    return User.builder()
      .username(member.getMemberSeq()+"")
      .password(passwordEncoder.encode(member.getKakao()))
      .roles(member.getRole())
      .build();
  }
}