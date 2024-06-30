package com.mwom.moyeora.profile;

import com.mwom.moyeora.member.MemberEntity;
import com.mwom.moyeora.member.MemberInfoEntity;
import com.mwom.moyeora.member.MemberRepository;
import com.mwom.moyeora.member.MemberSeq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@ResponseBody
@RequiredArgsConstructor
@RequestMapping("/api")
public class ProfileImageController {
  @Autowired
  MemberRepository memberRepository;

  @GetMapping("/all/profileImg")
  public  String memberReviewList(@Param("nickName")String nickName)  {
    System.out.println("nickName = " + nickName);
    String baseImgBlobimg=ProfileBaseImage.baseImgBlob;
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



}

