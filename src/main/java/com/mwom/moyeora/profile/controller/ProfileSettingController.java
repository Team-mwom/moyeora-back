package com.mwom.moyeora.profile.controller;

import com.mwom.moyeora.database.entity.MemberEntity;
import com.mwom.moyeora.database.entity.MemberInfoEntity;
import com.mwom.moyeora.database.repository.MemberInfoRepository;
import com.mwom.moyeora.database.repository.MemberRepository;
import com.mwom.moyeora.common.MemberSeq;
import com.mwom.moyeora.member.service.MemberService;
import com.mwom.moyeora.profile.ProfileBaseImage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Slf4j
@RestController
@ResponseBody
@RequiredArgsConstructor
@RequestMapping("/api")
public class ProfileSettingController {
  @Autowired
  MemberRepository memberRepository;
  @Autowired
  MemberInfoRepository memberInfoRepository;

  @Autowired
  MemberService memberService;

  @PostMapping("/user/changeNickName")
  public String changeNickName(@RequestBody MemberEntity memberEntity  ){


    long memberSeq = MemberSeq.getCurrentMemberSeq();
    MemberEntity entity = memberService.selectMemberBySeq(memberSeq);
    entity.setNickName(memberEntity.getNickName());

    entity.setMemberInfoEntity(null);
    memberService.save(entity);

    return "success";
  }
  
  
  @GetMapping("/all/profileImg")
  public  String memberReviewList(@Param("nickName")String nickName)  {
    System.out.println("nickName = " + nickName);
    String baseImgBlobimg= ProfileBaseImage.baseImgBlob;
    String imgBlob ="";
    MemberEntity memberEntity = memberRepository.findTopByNickName(nickName);
    if(memberEntity==null){
      return baseImgBlobimg;
    }
    MemberInfoEntity memberInfoEntity=memberEntity.getMemberInfoEntity();

    if(memberInfoEntity==null||memberInfoEntity.getProfileImg()==null||memberInfoEntity.getProfileImg().equals("")){
      return baseImgBlobimg;
    }
    imgBlob = memberInfoEntity.getProfileImg();

    return imgBlob;
  }

@PostMapping("/user/changeProfileImg")
  public String changeProfileImg(@RequestBody MemberInfoEntity memberInfoEntity ){

  long memberSeq = MemberSeq.getCurrentMemberSeq();
  memberInfoEntity.setMemberSeq(memberSeq);
  MemberInfoEntity entity = memberInfoRepository.findTopByMemberSeq(memberSeq).getMemberInfoEntity();
  entity.setProfileImg(memberInfoEntity.getProfileImg());
  memberInfoRepository.save(entity);



    return "success";
}

}

