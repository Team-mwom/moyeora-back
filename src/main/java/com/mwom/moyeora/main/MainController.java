package com.mwom.moyeora.main;

import com.mwom.moyeora.domain.entity.Moyeora;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@ResponseBody
@RequiredArgsConstructor
@RequestMapping("/api/main")
public class MainController {
    private final MainService mainService;

    @GetMapping()
    public String selectTodayMoyeoraList(Model model, Pageable pageable) {
        List<Moyeora> moyeoraList = mainService.selectTodayMoyeoraList(pageable);
        model.addAttribute("moyeoraList", moyeoraList);
        return "test 중";
    }

    @GetMapping("/searchMain")
    public void searchMain(String word){
        System.out.println("[word] ======> " + word);
        //return testService.selectTestAllList(mybatis);
    }
}
