package com.mwom.moyeora.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
@RequestMapping("/api/main")
public class MainController {

    @Autowired
    private MainService mainService;

    @GetMapping("/searchMain/{word}")
    public void searchMain(@PathVariable String word){
        System.out.println("word :: " + word);
        mainService.mainSearch(word);


        //System.out.println("[word] ======> " + word);
        //return testService.selectTestAllList(mybatis);
    }
}
