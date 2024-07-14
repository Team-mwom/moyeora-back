package com.mwom.moyeora.main;

import com.mwom.moyeora.domain.entity.Moyeora;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MainRepository extends JpaRepository<Moyeora, Long> {
    List<Moyeora> findTop4ByOrderByRegDtDesc();

    Page<Moyeora> findByMyrTitleContaining(String searchKeyword, Pageable pageable);
}
