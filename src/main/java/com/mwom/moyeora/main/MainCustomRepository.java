package com.mwom.moyeora.main;

import com.mwom.moyeora.database.entity.MoyeoraEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MainCustomRepository {
    Page<MoyeoraEntity> selectMoyeoraList(Pageable pageable);
}
