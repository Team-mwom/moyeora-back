package com.mwom.moyeora.test.repositorys;


import com.mwom.moyeora.test.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TestRepository extends JpaRepository<TestEntity,String> {
    @Query(value = "select * from test_table",nativeQuery = true)
    List<TestEntity> selectTestAllList();



    @Query(value = "insert into test_table(age,name,family,weight) values (:#{#entity.age},:#{#entity.name},:#{#entity.family},:#{#entity.weight})",nativeQuery = true)
    void insertTestInfo(@Param("entity") TestEntity testEntity);


}
