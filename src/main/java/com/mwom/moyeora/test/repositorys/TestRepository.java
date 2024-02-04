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
    //1
    @Query(value = "select * from test_table",nativeQuery = true)
    public List<TestEntity> selectTestAllList();

    //2//현재 코드에서 사용중
    public List<TestEntity> findAll();

    //여러가지 방법으로 가능한데 위에 첫번째 방법은 @Query를 사용해서 직접 query를 입력한 방법이다
    //위에 두번째 방법은 List<TestEntity> findAll()라고 하면 jpa가 알아서 TestEntity 에서 모두검색해라 라는 쿼리를 만들어준다.->select * from TestEntity
    //TestEntity가 db에 없기 때문에 TestEntity class에서 @Table(name="test_table")로 하여 select * from test_table 로 하도록 한다.
    //JPARepository method 사용 https://jobc.tistory.com/120

//-------------------------------


//-----------데이터 저장-----------

    //1
    @Query(value = "insert into test_table(age,name,family,weight) values (:#{#entity.age},:#{#entity.name},:#{#entity.family},:#{#entity.weight})",nativeQuery = true)
    public void insertTestInfo(@Param("entity") TestEntity testEntity);//@Param("entity") 를 사용하여 위에 query에서 entity라는 이름으로 매개변수로 받은 testEntity에 접근할수있다

    //2//현재 코드에서 사용중
    public TestEntity save(TestEntity entity);

    //idx 가 자동증가기 때문에 idx 정보없이 저장했지만 저장과 동시에 빼와야할 경우가 있는데
    //위에 첫번째 방법은 직접 query를 사용하는 방법인데 mybatis에서는 <selectKey> 를 사용하여 저장한 컬럼의 idx 를 바로 받을 수가 있는데 저 방식대로는 어케 받는지 모르겠다.
    //위에 두번째 방법에서는 JPARepository method 의 save 메서드로 리턴값으로 저장한 entity를 바로 받을 수 있고 안에 방금 저장한 idx가 포함되어있다.



//-------------------------------

    @Transactional
    public void deleteTestEntityByidx(int idx);
}
