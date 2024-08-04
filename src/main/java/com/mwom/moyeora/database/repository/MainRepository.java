package com.mwom.moyeora.database.repository;

import com.mwom.moyeora.database.entity.Moyeora;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MainRepository extends JpaRepository<Moyeora, Long> {
    List<Moyeora> findTop4ByOrderByRegDtDesc();

    Page<Moyeora> findByMyrTitleContaining(String searchKeyword, Pageable pageable);
}
