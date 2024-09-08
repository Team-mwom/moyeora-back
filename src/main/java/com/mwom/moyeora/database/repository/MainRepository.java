package com.mwom.moyeora.database.repository;

import com.mwom.moyeora.database.entity.MoyeoraEntity;
import com.mwom.moyeora.main.MainCustomRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MainRepository extends JpaRepository<MoyeoraEntity, Long>, MainCustomRepository {
    List<MoyeoraEntity> findTop4ByOrderByRegDtDesc();

    Page<MoyeoraEntity> selectMoyeoraList(Pageable pageable);

    Page<MoyeoraEntity> findByMyrTitleContaining(String searchKeyword, Pageable pageable);


}
