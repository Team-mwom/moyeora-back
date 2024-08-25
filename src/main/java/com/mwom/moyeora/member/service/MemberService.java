package com.mwom.moyeora.member.service;

import com.mwom.moyeora.database.entity.MemberEntity;
import com.mwom.moyeora.database.entity.MemberInfoEntity;
import com.mwom.moyeora.database.repository.MemberInfoRepository;
import com.mwom.moyeora.database.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

  @Autowired
  private MemberRepository memberRepository;



  @Transactional
  public MemberEntity selectMemberByNick(String nickName) {
   return memberRepository.findTopByNickName(nickName);
  }
}