package com.mwom.moyeora.database.repository;

import com.mwom.moyeora.database.entity.FriendEntity;
import com.mwom.moyeora.database.entity.ReviewEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriedRepository extends JpaRepository<FriendEntity, Long> {

  public FriendEntity save(FriendEntity friendEntity);

  public void deleteAllByMemberSeqAndFriendMemberSeq(long memberSeq, long friendMemberSeq);

  public FriendEntity findTopByMemberSeqAndFriendMemberSeq(long memberSeq, long friendMemberSeq);

  public long countByMemberSeq(long memberSeq);
  public long countByFriendMemberSeq(long friendMemberSeq);
}