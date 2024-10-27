package com.mwom.moyeora.category.service;

import com.mwom.moyeora.database.entity.SubCategoryEntity;
import com.mwom.moyeora.database.repository.SubCategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SubCategoryService {

    @Autowired
    private final SubCategoryRepository subCategoryRepository;

    /**
     * 서브 카테고리 전체 검색
     * SubCategoryService.selectSubCategoryList
     * @return List<SubCategoryEntity>
     */
    public List<SubCategoryEntity> findSubCategoryList(long categorySeq) {

        return subCategoryRepository.findBySubCategorySeq(categorySeq);
    }
}
