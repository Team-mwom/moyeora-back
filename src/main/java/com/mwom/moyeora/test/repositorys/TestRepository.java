package com.mwom.moyeora.test.repositorys;


import com.mwom.moyeora.test.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface TestRepository extends JpaRepository<TestEntity,String> {


//---------모든 리스트 가져오기------

    //@Query(value = "select * from test_table",nativeQuery = true)
    //public List<TestEntity> selectTestAllList();

    public List<TestEntity> findAll();//jparepository method


//-----------데이터 저장-----------
    //@Query(value = "insert into test_table(age,name,family,weight) values (:#{#entity.age},:#{#entity.name},:#{#entity.family},:#{#entity.weight})",nativeQuery = true)
   // public void insertTestInfo(@Param("entity") TestEntity testEntity);//@Param("entity") 를 사용하여 위에 query에서 entity라는 이름으로 매개변수로 받은 testEntity에 접근할수있다
    public TestEntity save(TestEntity entity);

    @Transactional
    public void deleteTestEntityByidx(int idx);


    @Query(value = "update test_table set age =:#{#entity.age},name=:#{#entity.name},family=:#{#entity.family},weight=:#{#entity.weight} where idx = :#{#entity.idx} ",nativeQuery = true)
    public void updateTestInfo(@Param("entity") TestEntity testEntity);
}
