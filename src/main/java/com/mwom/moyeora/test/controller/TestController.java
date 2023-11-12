package com.mwom.moyeora.test.controller;

import com.mwom.moyeora.test.service.TestService;
import com.mwom.moyeora.test.vo.TestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
    @Autowired
    private TestService testService;

    @GetMapping("/test")
    public List<TestVo> test(){
       return testService.selectAllList();
    }

    @GetMapping("/api/hello")
    public String hello(){
        String str = "hello world!";
        return str;
    }
//test
}