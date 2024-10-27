package com.mwom.moyeora.database.repository;

import com.mwom.moyeora.database.entity.SubCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubCategoryRepository extends JpaRepository<SubCategoryEntity, Long> {

    /**
     * 서브 카테고리 전체 검색
     * SubCategoryRepository.selectCategoryList
     * @return List<SubCategoryEntity>
     */
    List<SubCategoryEntity> findBySubCategorySeq(long categorySeq);
}
