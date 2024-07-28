package com.mwom.moyeora.moyeora;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@ResponseBody
@RequiredArgsConstructor
@RequestMapping("/api/moyeora")
public class MoyeoraController {

    @Autowired
    private MoyeoraService moyeoraService;

    @PostMapping("/create-moyeora")
    public MoyeoraMainDto insertMoyeoraInfo(@RequestBody MoyeoraMainDto moyeoraMainDto) {
        moyeoraService.insertMoyeoraInfo(moyeoraMainDto);

        return moyeoraMainDto;
    }
}
