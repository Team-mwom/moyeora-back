package com.mwom.moyeora.category.controller;

import com.mwom.moyeora.category.service.SubCategoryService;
import com.mwom.moyeora.database.entity.SubCategoryEntity;
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
public class SubCategoryController {

    @Autowired
    private SubCategoryService subCategoryService;

    /**
     * 서브 카테고리 검색
     * SubCategoryController.selectSubCategoryList
     * @return List<CategoryEntity>
     */
    @GetMapping("/all/sub-category/search-sub-category")
    public List<SubCategoryEntity> findSubCategoryList (long categorySeq) {

        return subCategoryService.findSubCategoryList(categorySeq);
    }
}
