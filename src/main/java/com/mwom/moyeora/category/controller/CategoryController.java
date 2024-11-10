package com.mwom.moyeora.category.controller;

import com.mwom.moyeora.category.service.CategoryService;
import com.mwom.moyeora.category.service.SubCategoryService;
import com.mwom.moyeora.database.entity.CategoryEntity;
import com.mwom.moyeora.database.entity.SubCategoryEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@ResponseBody
@RequiredArgsConstructor
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private SubCategoryService subCategoryService;

    /**
     * 카테고리 검색
     * CategoryController.selectSearchModalData
     * @return Map<String, Object>
     */
    @GetMapping("/all/category/search-category")
    public Map<String, Object> selectSearchModalData(){

        // 카테고리와 시군구 반환을 위한 Map
        Map<String, Object> searchModalDataMap = new HashMap<>();

        // 카테고리 List
        List<CategoryEntity> categoryList = categoryService.selectCategoryList("Y");
        searchModalDataMap.put("categories", categoryList);

        // 서브카테고리 List
        List<SubCategoryEntity> subCategoryList = subCategoryService.selectsubCategoryList();
        searchModalDataMap.put("subCategories", subCategoryList);

        System.out.println("subCategoryList = " + subCategoryList);

        return searchModalDataMap;
    }

}
