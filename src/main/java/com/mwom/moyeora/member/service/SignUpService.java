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
public class SignUpService {

  @Autowired
  private MemberRepository memberRepository;
  @Autowired
  private MemberInfoRepository memberInfoRepository;



  public void signUp(MemberEntity memberEntity) {

    //받아온 memberEntity에서 memberInfoEntity를 제외하고 넣어준 후 다시 memberInfoEntity를 포함하여 넣어주는 과정
    //memberEntity의 member_seq가 auto_incremant라서 기본키가 먼저 생성된 후 memberInfoEntity를 넣어줄 수 있음
    //memberInfoEntity에서 member_seq를 참조 하고 있기 때문에 같이 insert못함

    MemberInfoEntity memberInfoEntity = new MemberInfoEntity();
    memberInfoEntity = memberEntity.getMemberInfoEntity();//날라온 정보중에 memberInfoEntity만 따로 저장해둔다.
    System.out.println("memberInfoEntity = " + memberInfoEntity);
     memberEntity.setMemberInfoEntity(null);//memberInfoEntity를 null로해서
     memberEntity = memberRepository.save(memberEntity);//insert한 후 정보를 다시 받는다

    memberInfoEntity.setMemberSeq(memberEntity.getMemberSeq());////memberInfoEntity에 member_seq를 넣어준다.
    memberInfoRepository.save(memberInfoEntity);




  }

  @Transactional
  public boolean checkNickName(String nickName) {
  if(memberRepository.findTopByNickName(nickName)==null){
    return true;
  }
  return false;

  }
}