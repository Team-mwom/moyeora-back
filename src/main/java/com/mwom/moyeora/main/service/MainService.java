package com.mwom.moyeora.main.service;

import com.mwom.moyeora.database.entity.MoyeoraEntity;
import com.mwom.moyeora.database.repository.MainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MainService {

    @Autowired
    private final MainRepository mainRepository;

    public List<MoyeoraEntity> selectTodayMoyeoraList() {
        List<MoyeoraEntity> moyeoraList = mainRepository.findTop4ByOrderByRegDtDesc();
        return moyeoraList;
    }

    public Page<MoyeoraEntity> selectMoyeoraList(Pageable pageable) {
        return mainRepository.selectMoyeoraList(pageable);
    }

    public Page<MoyeoraEntity> selectMainSearch(String word, int page, int size) {
        return mainRepository.findByMyrTitleContaining(word, PageRequest.of(page, size));
    }
}
