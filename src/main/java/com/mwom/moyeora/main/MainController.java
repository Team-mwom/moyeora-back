package com.mwom.moyeora.main;

import com.mwom.moyeora.domain.entity.Moyeora;
import com.mwom.moyeora.moyeora.MoyeoraVo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@ResponseBody
@RequiredArgsConstructor
@RequestMapping("/api/all/main")
public class MainController {
    private final MainService mainService;

    @GetMapping()
    public List<MoyeoraVo> selectTodayMoyeoraList(Model model, Pageable pageable) {
        List<Moyeora> moyeoraList = mainService.selectTodayMoyeoraList(pageable);

        List<MoyeoraVo> moyeoraVoList = moyeoraList.stream()
                .map(m -> new MoyeoraVo(m))
                .collect(Collectors.toList());

        model.addAttribute("moyeoraVoList", moyeoraVoList);
        return moyeoraVoList;
    }

    @GetMapping("/searchMain")
    public void searchMain(String word){
        System.out.println("[word] ======> " + word);
        //return testService.selectTestAllList(mybatis);
    }
}
