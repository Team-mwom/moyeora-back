package com.mwom.moyeora.moyeora.service;

import com.mwom.moyeora.database.dto.MoyeoraDto;
import com.mwom.moyeora.database.dto.MoyeoraInfoDto;
import com.mwom.moyeora.database.dto.MoyeoraMainDto;
import com.mwom.moyeora.database.dto.MoyeoraPlaceDto;
import com.mwom.moyeora.database.entity.MoyeoraEntity;
import com.mwom.moyeora.database.entity.MoyeoraInfoEntity;
import com.mwom.moyeora.database.entity.MoyeoraPlaceEntity;
import com.mwom.moyeora.database.repository.MoyeoraInfoRepository;
import com.mwom.moyeora.database.repository.MoyeoraPlaceRepository;
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

    @Autowired
    private MoyeoraPlaceRepository moyeoraPlaceRepository;

    /**
     * 모여라 생성
     * @param moyeoraMainDto
     * @return int
     */
    public int insertMoyeoraInfo (MoyeoraMainDto moyeoraMainDto) {
        // 1. 모여라 Insert
        // 2. 모여라 상세 Insert
        // 3. 모여라 장소 Insert
        int result = -1;

        // Dto 변수 생성
        MoyeoraDto moyeoraDto = new MoyeoraDto();
        MoyeoraInfoDto moyeoraInfoDto = new MoyeoraInfoDto();
        MoyeoraPlaceDto moyeoraPlaceDto = new MoyeoraPlaceDto();

        moyeoraDto = moyeoraMainDto.getMoyeoraDto();
        moyeoraInfoDto = moyeoraMainDto.getMoyeoraInfoDto();
        moyeoraPlaceDto = moyeoraMainDto.getMoyeoraPlaceDto();

        System.out.println("moyeoraMainDto Service Value = " + moyeoraMainDto);
        System.out.println("moyeoraDto Service Value = " + moyeoraDto);
        System.out.println("moyeoraInfoDto Service Value = " + moyeoraInfoDto);
        System.out.println("moyeoraPlaceDto Service Value = " + moyeoraPlaceDto);

        // Entity에 Insert
        MoyeoraEntity moyeoraEntity = MoyeoraEntity.toEntity(moyeoraDto);
        // 1. 모여라 Insert
        moyeoraEntity = moyeoraRepository.save(moyeoraEntity);

        MoyeoraInfoEntity moyeoraInfoEntity = MoyeoraInfoEntity.toEntity(moyeoraInfoDto);
        moyeoraInfoEntity.setMyrSeq(moyeoraEntity.getMyrSeq());
        // 2. 모여라 상세 Insert
        moyeoraInfoEntity = moyeoraInfoRepository.save(moyeoraInfoEntity);

        MoyeoraPlaceEntity moyeoraPlaceEntity = MoyeoraPlaceEntity.toEntity(moyeoraPlaceDto);
        // 3. 모여라 장소 Insert
        moyeoraPlaceEntity = moyeoraPlaceRepository.save(moyeoraPlaceEntity);

        return result;
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