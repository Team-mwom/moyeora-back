package com.mwom.moyeora.test.controller;

import com.mwom.moyeora.test.service.TestService;
import com.mwom.moyeora.test.vo.TestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestController {
    @Autowired
    private TestService testService;

    @GetMapping("/selectAllList")
    public List<TestVo> selectAllList(){
        return testService.selectAllList();
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