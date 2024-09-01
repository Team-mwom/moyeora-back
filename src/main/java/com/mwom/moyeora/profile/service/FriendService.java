package com.mwom.moyeora.profile.service;

import com.mwom.moyeora.database.dto.ReviewDto;
import com.mwom.moyeora.database.entity.FriendEntity;
import com.mwom.moyeora.database.entity.ReviewEntity;
import com.mwom.moyeora.database.repository.FriedRepository;
import com.mwom.moyeora.database.repository.ReviewRepository;
import com.mwom.moyeora.profile.ProfileBaseImage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class FriendService {

  @Autowired
  private FriedRepository friedRepository;

  public FriendEntity follow(FriendEntity friendEntity){
    return friedRepository.save(friendEntity);
  }

  public void unfollow(long memberSeq,long friendMemberSeq){
    friedRepository.deleteAllByMemberSeqAndFriendMemberSeq(memberSeq,friendMemberSeq);
    friedRepository.flush();
  }

  public boolean isFollow(long memberSeq,long friendMemberSeq){
    if(friedRepository.findTopByMemberSeqAndFriendMemberSeq(memberSeq,friendMemberSeq)==null){
      return false;
    }
    return true;
  }

  public long followers(long friendMemberSeq){
    return friedRepository.countByFriendMemberSeq(friendMemberSeq);
  }
  public long follings(long memberSeq){
    return friedRepository.countByMemberSeq(memberSeq);
  }


}