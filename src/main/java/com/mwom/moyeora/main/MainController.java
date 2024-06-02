package com.mwom.moyeora.main;

import com.mwom.moyeora.domain.entity.Moyeora;
import com.mwom.moyeora.moyeora.MoyeoraVo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@ResponseBody
@RequiredArgsConstructor
@RequestMapping("/api/all/main")
public class MainController {
    private final MainService mainService;

    @GetMapping("/test")
    public List<MoyeoraVo> selectTodayMoyeoraList(Model model) {
        List<Moyeora> moyeoraList = mainService.selectTodayMoyeoraList();

        List<MoyeoraVo> moyeoraVoList = moyeoraList.stream()
                .map(m -> new MoyeoraVo(m))
                .collect(Collectors.toList());

        model.addAttribute("moyeoraVoList", moyeoraVoList);
        return moyeoraVoList;
    }

    @GetMapping("/list")
    public ResponseEntity<Map<String, Object>> selectMoyeoraList(Model model, Pageable pageable) {
        Page<Moyeora> moyeoraList = mainService.selectMoyeoraList(pageable);

        List<MoyeoraVo> moyeoraVoList = moyeoraList.stream()
                .map(m -> new MoyeoraVo(m))
                .collect(Collectors.toList());

        Map<String, Object> map = new HashMap<>();
        map.put("moyeoraVoList", moyeoraVoList);
        return ResponseEntity.ok().body(map);
    }

    @GetMapping("/searchMain/{word}")
    public void searchMain(@PathVariable String word){
        System.out.println("word :: " + word);
        mainService.mainSearch(word);


        //System.out.println("[word] ======> " + word);
        //return testService.selectTestAllList(mybatis);
    }
}
