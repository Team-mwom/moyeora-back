package com.mwom.moyeora.main;

import com.mwom.moyeora.domain.entity.Moyeora;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MainCustomRepository {
    Page<Moyeora> selectMoyeoraList(Pageable pageable);
}
