package com.mwom.moyeora.database.repository;

import com.mwom.moyeora.database.entity.MoyeoraEntity;
import com.mwom.moyeora.database.entity.MoyeoraInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoyeoraInfoRepository extends JpaRepository<MoyeoraEntity, Long> {

    MoyeoraInfoEntity save(MoyeoraInfoEntity moyeoraInfo);

//    List<Moyeora> findTop4ByOrderByRegDtDesc();
//
//    Page<Moyeora> selectMoyeoraList(SearchVo searchVo, Pageable pageable);
}
