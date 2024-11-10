package com.mwom.moyeora.profile.controller;

import com.mwom.moyeora.common.MemberSeq;
import com.mwom.moyeora.database.dto.FriendDto;
import com.mwom.moyeora.database.dto.ReviewDto;
import com.mwom.moyeora.database.entity.FriendEntity;
import com.mwom.moyeora.database.entity.ReviewEntity;
import com.mwom.moyeora.database.repository.MemberRepository;
import com.mwom.moyeora.member.service.MemberService;
import com.mwom.moyeora.profile.service.FriendService;
import com.mwom.moyeora.profile.service.ReviewService;
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
public class FriendController {

  @Autowired
  private FriendService friendService;
  @Autowired
  private MemberService memberService;
 


  @PostMapping("/user/follow")
  public String follow(@RequestBody String [] friendNick){
    long memberSeq =MemberSeq.getCurrentMemberSeq();
    long friendMemberSeq =memberService.selectMemberByNick(friendNick[0]).getMemberSeq();
    FriendEntity friendEntity = new FriendEntity();
    friendEntity.setMemberSeq(memberSeq);
    friendEntity.setFriendMemberSeq(friendMemberSeq);
    friendEntity.setModId(memberSeq);
    friendEntity.setRegId(memberSeq);
    friendService.follow(friendEntity);
    return "success";
  }
  @PostMapping("/user/unfollow")
  public String unfollow(@RequestBody String [] friendNick){
    long memberSeq =MemberSeq.getCurrentMemberSeq();
    long friendMemberSeq =memberService.selectMemberByNick(friendNick[0]).getMemberSeq();
    friendService.unfollow(memberSeq,friendMemberSeq);
    return "success";
  }
  @PostMapping("/user/isFollow")
  public boolean isFollow(@RequestBody String [] friendNick) {
    long memberSeq = MemberSeq.getCurrentMemberSeq();
    long friendMemberSeq = memberService.selectMemberByNick(friendNick[0]).getMemberSeq();
    return friendService.isFollow(memberSeq, friendMemberSeq);
  }
 @PostMapping("/all/followState")
  public FriendDto followState(@RequestBody String [] friendNick) {
    FriendDto friendDto = new FriendDto();
    long friendMemberSeq = memberService.selectMemberByNick(friendNick[0]).getMemberSeq();
    friendDto.setFollowers(friendService.followers(friendMemberSeq));
    friendDto.setFollowings(friendService.follings(friendMemberSeq));
    return friendDto;
  }

}

