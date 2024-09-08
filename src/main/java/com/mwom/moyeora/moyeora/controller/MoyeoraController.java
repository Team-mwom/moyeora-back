package com.mwom.moyeora.moyeora.controller;

import com.mwom.moyeora.common.MemberSeq;
import com.mwom.moyeora.database.dto.MoyeoraMainDto;
import com.mwom.moyeora.database.entity.MoyeoraEntity;
import com.mwom.moyeora.database.vo.MoyeoraVo;
import com.mwom.moyeora.moyeora.service.MoyeoraService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@ResponseBody
@RequiredArgsConstructor
@RequestMapping("/api")
public class MoyeoraController {

    @Autowired
    private MoyeoraService moyeoraService;

    /**
     * 모여라 생성
     * @param moyeoraMainDto
     * @return int
     */
    @PostMapping("/user/moyeora/create-moyeora")
    public int insertMoyeoraInfo(@RequestBody MoyeoraMainDto moyeoraMainDto) {
        int result = -1;

        result += moyeoraService.insertMoyeoraInfo(moyeoraMainDto);

        return result;
    }

    @GetMapping("all/moyeora/active-moyeora")//참여한 모여라 검색
    public List<MoyeoraEntity> selectActiveMoyeora (String nickName){

        System.out.println("nickName = " + nickName);
        moyeoraService.selectActiveMoyeora(nickName);
        return null;
    }
}