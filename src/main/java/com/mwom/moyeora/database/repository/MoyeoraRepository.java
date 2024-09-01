package com.mwom.moyeora.database.repository;

import com.mwom.moyeora.database.dto.MoyeoraDto;
import com.mwom.moyeora.database.entity.MoyeoraEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoyeoraRepository extends JpaRepository<MoyeoraEntity, Long> {

    MoyeoraEntity save(MoyeoraEntity moyeoraEntity);

//    List<Moyeora> findTop4ByOrderByRegDtDesc();
//
//    Page<Moyeora> selectMoyeoraList(SearchVo searchVo, Pageable pageable);
}
