package com.mwom.moyeora.test.controller;

import com.mwom.moyeora.test.entity.TestEntity;
import com.mwom.moyeora.test.repositorys.TestRepository;
import com.mwom.moyeora.test.service.TestService;
import com.mwom.moyeora.test.vo.TestVo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

@RestController
@ResponseBody
public class TestController {
    @Autowired
    private TestService testService;



    @GetMapping("/selectTestAllList")
    public List<?> selectTestAllList(boolean mybatis){
        return testService.selectTestAllList(mybatis);

    }



    @PostMapping("/insertTestInfo")
    public boolean insertTestInfo(@RequestBody TestEntity testEntity){

        System.out.println(testEntity);
        testService.insertTestInfo(testEntity);
        return true;
    }
    @GetMapping("/api/hello")
    public String hello(){
        String str = "hello world!";
        return str;

    }


}