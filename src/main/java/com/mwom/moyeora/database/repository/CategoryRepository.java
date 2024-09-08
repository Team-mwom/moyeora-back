package com.mwom.moyeora.database.repository;

import com.mwom.moyeora.database.entity.CategoryEntity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    List<CategoryEntity> findByCategoryClassYnEquals(String categoryClassYn);
}
