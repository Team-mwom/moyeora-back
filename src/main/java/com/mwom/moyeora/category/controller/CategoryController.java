package com.mwom.moyeora.category.controller;

import com.mwom.moyeora.category.service.CategoryService;
import com.mwom.moyeora.database.entity.CategoryEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@ResponseBody
@RequiredArgsConstructor
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 카테고리 전체 검색
     * CategoryController.selectCategoryList
     * @return List<CategoryEntity>
     */
    @GetMapping("/all/category/search-category")
    public List<CategoryEntity> findCategoryList() {

        return categoryService.findCategoryList();
    }

}
