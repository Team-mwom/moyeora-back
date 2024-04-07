package com.mwom.moyeora.main;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@ResponseBody
@RequestMapping("/api/main")
public class MainController {

    @GetMapping("/searchMain")
    public void searchMain(String word){
        System.out.println("[word] ======> " + word);
        //return testService.selectTestAllList(mybatis);
    }
}
