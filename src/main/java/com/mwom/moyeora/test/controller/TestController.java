package com.mwom.moyeora.test.controller;

import com.mwom.moyeora.test.entity.TestEntity;
import com.mwom.moyeora.test.repository.TestRepository;
import com.mwom.moyeora.test.service.TestService;
import com.mwom.moyeora.test.vo.TestVo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TestController {
    @Autowired
    private TestService testService;

    private final TestRepository testRepository;

    @PersistenceContext
    private EntityManager entityManager;


//    @GetMapping("/selectAllList")
//    public List<TestVo> selectAllList(){
//        return testService.selectAllList();
//    }

    @GetMapping("/selectAllList")
    public List<TestEntity> selectAllList(){
        return testRepository.selectAllList();
    }


    @ResponseBody
    @PostMapping("/insertInfo")
    public String insertInfo(@RequestBody TestVo testVo){
        System.out.println(testVo);
        return "";
    }
    @GetMapping("/api/hello")
    public String hello(){
        String str = "hello world!";
        return str;

    }


}