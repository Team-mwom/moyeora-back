package com.mwom.moyeora.moyeora;

import com.mwom.moyeora.domain.entity.Moyeora;
import com.mwom.moyeora.domain.entity.MoyeoraInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MoyeoraRepository extends JpaRepository<Moyeora, Long> {

    Moyeora save(Moyeora moyeora);

//    List<Moyeora> findTop4ByOrderByRegDtDesc();
//
//    Page<Moyeora> selectMoyeoraList(SearchVo searchVo, Pageable pageable);
}
