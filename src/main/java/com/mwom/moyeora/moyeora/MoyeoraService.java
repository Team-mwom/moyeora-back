package com.mwom.moyeora.moyeora;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MoyeoraService {
    private final MoyeoraMapper moyeoraMapper;
    private final MoyeoraRepository moyeoraRepository;

    public Map<String, Object> selectMoyeoraList(Pageable pageable) {
//        Page<MoyeoraVo> moyeoraVoPage = moyeoraRepository.selectMoyeoraList(searchVo, pageable);
//
//        Map<String, Object> map = new HashMap<>();
//
//        int count = moyeoraMapper.selectMoyeoraListCount(searchVo);
//        Pagination pagination = new Pagination(count, searchVo);
//        searchVo.setPagination(pagination);
////        List<MoyeoraVo> moyeoraList = moyeoraMapper.selectMoyeoraList(searchVo);
//
////        map.put("moyeoraList", moyeoraList);
//        map.put("moyeoraList", null);
//        map.put("pagination", pagination);
//        map.put("searchVo", searchVo);
//
//        return map;
        return null;
    }
}
