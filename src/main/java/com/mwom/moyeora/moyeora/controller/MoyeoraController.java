package com.mwom.moyeora.moyeora.controller;

import com.mwom.moyeora.common.MemberSeq;
import com.mwom.moyeora.database.dto.MoyeoraMainDto;
import com.mwom.moyeora.moyeora.service.MoyeoraService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@ResponseBody
@RequiredArgsConstructor
@RequestMapping("/api")
public class MoyeoraController {

    @Autowired
    private MoyeoraService moyeoraService;

    @PostMapping("/user/moyeora/create-moyeora")
    public MoyeoraMainDto insertMoyeoraInfo(@RequestBody MoyeoraMainDto moyeoraMainDto) {


        return moyeoraMainDto;
    }
}
