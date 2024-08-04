package com.mwom.moyeora.database.repository;

import com.mwom.moyeora.database.entity.Moyeora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoyeoraRepository extends JpaRepository<Moyeora, Long> {

    Moyeora save(Moyeora moyeora);

//    List<Moyeora> findTop4ByOrderByRegDtDesc();
//
//    Page<Moyeora> selectMoyeoraList(SearchVo searchVo, Pageable pageable);
}
