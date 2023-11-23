package com.mwom.moyeora.test.service;

import com.mwom.moyeora.test.entity.TestEntity;
import com.mwom.moyeora.test.mappers.TestMapper;
import com.mwom.moyeora.test.repositorys.TestRepository;
import com.mwom.moyeora.test.vo.TestVo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TestService {
    @Autowired
    private TestMapper testMapper;

    @Autowired
    private final TestRepository testRepository;

    @PersistenceContext
    private EntityManager entityManager;





    public List<?> selectTestAllList(boolean mybatis){

        if(mybatis){
            System.out.println("MyBatis");
            return testMapper.selectTestAllList();
        }
        System.out.println("JPA");
        return testRepository.selectTestAllList();

    }

    public void insertTestInfo(TestEntity testEntity){
       testRepository.insertTestInfo(testEntity);
    }

}
