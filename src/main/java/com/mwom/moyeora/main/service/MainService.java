package com.mwom.moyeora.main.service;

import com.mwom.moyeora.database.entity.CategoryEntity;
import com.mwom.moyeora.database.entity.SubCategoryEntity;
import com.mwom.moyeora.database.entity.MoyeoraEntity;
import com.mwom.moyeora.database.repository.CategoryRepository;
import com.mwom.moyeora.database.repository.MainRepository;
import com.mwom.moyeora.database.repository.SubCategoryRepository;
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
    @Autowired
    private final CategoryRepository categoryRepository;
    @Autowired
    private final SubCategoryRepository subCategoryRepository;

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

    public List<CategoryEntity> selectCategoryList(String categoryClassYn){
        return categoryRepository.findByCategoryClassYnEquals(categoryClassYn);
    }

    public List<SubCategoryEntity> selectsubCategoryList(){
        return subCategoryRepository.findAll();
    }
}
