package com.mwom.moyeora.database.repository;

import com.mwom.moyeora.database.entity.MoyeoraMemberEntity;
import com.mwom.moyeora.database.entity.MoyeoraPlaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MoyeoraMemberRepository extends JpaRepository<MoyeoraMemberEntity, Long> {

 public List<MoyeoraMemberEntity> findAllByMemberMemberSeq(long memberSeq);

}
