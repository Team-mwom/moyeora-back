package com.mwom.moyeora.category.service;

import com.mwom.moyeora.database.dto.CategoryDto;
import com.mwom.moyeora.database.entity.CategoryEntity;
import com.mwom.moyeora.database.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryService {

    @Autowired
    private final CategoryRepository categoryRepository;

    /**
     * 카테고리 전체 검색
     * CategoryService.selectCategoryList
     * @return List<CategoryEntity>
     */
    public List<CategoryEntity> findCategoryList() {

        return categoryRepository.findCategoryList();
    }
}
