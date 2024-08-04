package com.mwom.moyeora.database.repository;

import com.mwom.moyeora.database.entity.Moyeora;
import com.mwom.moyeora.database.entity.MoyeoraInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoyeoraInfoRepository extends JpaRepository<Moyeora, Long> {

    MoyeoraInfo save(MoyeoraInfo moyeoraInfo);

//    List<Moyeora> findTop4ByOrderByRegDtDesc();
//
//    Page<Moyeora> selectMoyeoraList(SearchVo searchVo, Pageable pageable);
}
