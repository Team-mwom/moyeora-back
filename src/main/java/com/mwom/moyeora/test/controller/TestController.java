package com.mwom.moyeora.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public String test(){
        String str = "{\"name\": \"식빵\",\"family\": \"웰시코기\",\"age\": 1,\"weight\": 2.14}";
        return str;
    }

    @GetMapping("/api/hello")
    public String hello(){
        String str = "hello world!";
        return str;
    }

}