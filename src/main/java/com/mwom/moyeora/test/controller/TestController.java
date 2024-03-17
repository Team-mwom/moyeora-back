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
@RequestMapping("/api/all")
public class TestController {
    @Autowired
    private TestService testService;



    @GetMapping("/selectTestAllList")
    public List<?> selectTestAllList(boolean mybatis){
        return testService.selectTestAllList(mybatis);
    }



    @PostMapping("/insertTestInfo")
    public TestEntity insertTestInfo(@RequestBody TestEntity testEntity){
        return testService.insertTestInfo(testEntity);
    }


    @GetMapping("/deleteTestInfo")
    public void deleteTestInfo(int idx){
        testService.deleteTestInfo(idx);

    }
    @PostMapping("/updateTestInfo")
    public void updateTestInfo(@RequestBody TestEntity entity){
        testService.updateTestInfo(entity);

    }


}