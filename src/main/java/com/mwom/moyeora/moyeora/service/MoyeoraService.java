package com.mwom.moyeora.moyeora.service;

import com.mwom.moyeora.database.dto.MoyeoraMainDto;
import com.mwom.moyeora.database.entity.Moyeora;
import com.mwom.moyeora.database.entity.MoyeoraInfo;
import com.mwom.moyeora.database.repository.MoyeoraInfoRepository;
import com.mwom.moyeora.database.repository.MoyeoraRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MoyeoraService {

    @Autowired
    private MoyeoraRepository moyeoraRepository;

    @Autowired
    private MoyeoraInfoRepository moyeoraInfoRepository;

    public MoyeoraMainDto insertMoyeoraInfo (MoyeoraMainDto moyeoraMainDto) {
        Moyeora moyeora = new Moyeora();
        MoyeoraInfo moyeoraInfo = new MoyeoraInfo();

        moyeora = moyeoraMainDto.getMoyeoraEntity();
        moyeoraInfo = moyeoraMainDto.getMoyeoraInfoEntity();

        log.debug("MoyeoraMainDto Value= {}", moyeoraMainDto);
        log.debug("moyeora Value= {}", moyeora);
        log.debug("moyeoraInfo Value= {}", moyeoraInfo);

        moyeora = moyeoraRepository.save(moyeora);

        moyeoraInfo.setMyrSeq(moyeoraInfo.getMyrSeq());

        moyeoraInfo = moyeoraInfoRepository.save(moyeoraInfo);

        return moyeoraMainDto;
    }

//    private final MoyeoraMapper moyeoraMapper;
//    private final MoyeoraRepository moyeoraRepository;

//    public Map<String, Object> selectMoyeoraList(Pageable pageable) {
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
//        return null;
//    }
}
