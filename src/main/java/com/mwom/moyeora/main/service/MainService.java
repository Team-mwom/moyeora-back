package com.mwom.moyeora.main.service;

import com.mwom.moyeora.database.entity.Moyeora;
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

    public List<Moyeora> selectTodayMoyeoraList() {
        List<Moyeora> moyeoraList = mainRepository.findTop4ByOrderByRegDtDesc();
        return moyeoraList;
    }

    public Page<Moyeora> selectMoyeoraList(Pageable pageable) {
        return mainRepository.selectMoyeoraList(pageable);
    }

    public Page<Moyeora> selectMainSearch(String word, int page, int size) {
        return mainRepository.findByMyrTitleContaining(word, PageRequest.of(page, size));
    }
}
