package com.mwom.moyeora.test.repository;


import com.mwom.moyeora.test.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestRepository extends JpaRepository<TestEntity,String> {
    @Query(value = "select * from test_table",nativeQuery = true)
    List<TestEntity> selectAllList();
}
