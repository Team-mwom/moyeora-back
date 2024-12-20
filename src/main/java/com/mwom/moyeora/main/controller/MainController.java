package com.mwom.moyeora.main.controller;

import com.mwom.moyeora.database.entity.CategoryEntity;
import com.mwom.moyeora.database.entity.MoyeoraEntity;
import com.mwom.moyeora.database.entity.SubCategoryEntity;
import com.mwom.moyeora.main.service.MainService;
import com.mwom.moyeora.database.vo.MoyeoraVo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
        List<MoyeoraEntity> moyeoraList = mainService.selectTodayMoyeoraList();

        List<MoyeoraVo> moyeoraVoList = moyeoraList.stream()
                .map(m -> new MoyeoraVo(m))
                .collect(Collectors.toList());

        model.addAttribute("moyeoraVoList", moyeoraVoList);
        return moyeoraVoList;
    }

    @GetMapping("/list")
    public List<MoyeoraVo> selectMoyeoraList(Model model, Pageable pageable) {
        Page<MoyeoraEntity> moyeoraList = mainService.selectMoyeoraList(pageable);

        List<MoyeoraVo> moyeoraVoList = moyeoraList.stream()
                .map(m -> new MoyeoraVo(m))
                .collect(Collectors.toList());

        model.addAttribute("moyeoraVoList", moyeoraVoList);
        return moyeoraVoList;
    }

    @GetMapping("/selectSearchMain")
    public ResponseEntity<Map<String, Object>> selectSearchMain(@RequestParam String word,
                                                                @RequestParam int page,
                                                                @RequestParam int size){
        Page<MoyeoraEntity> searchList = mainService.selectMainSearch(word, page, size);

        List<MoyeoraVo> searchVoList = searchList.stream()
                .map(m -> new MoyeoraVo(m))
                .collect(Collectors.toList());

        Map<String, Object> response = new HashMap<>();
        response.put("content", searchVoList);
        response.put("currentPage", searchList.getNumber());
        response.put("totalPages", searchList.getTotalPages());
        response.put("totalElements", searchList.getTotalElements());
        response.put("size", searchList.getSize());

        return ResponseEntity.ok(response);
    }


}
