package com.mwom.moyeora.moyeora.service;

import com.mwom.moyeora.database.dto.MoyeoraDto;
import com.mwom.moyeora.database.dto.MoyeoraInfoDto;
import com.mwom.moyeora.database.dto.MoyeoraMainDto;
import com.mwom.moyeora.database.dto.MoyeoraPlaceDto;
import com.mwom.moyeora.database.entity.*;
import com.mwom.moyeora.database.repository.MoyeoraInfoRepository;
import com.mwom.moyeora.database.repository.MoyeoraMemberRepository;
import com.mwom.moyeora.database.repository.MoyeoraPlaceRepository;
import com.mwom.moyeora.database.repository.MoyeoraRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    private MoyeoraMemberRepository moyeoraMemberRepository;

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




        //////
        SubCategoryEntity subCategoryEntity = new SubCategoryEntity();//서브카테고리 객체를 만들고
        subCategoryEntity.setSubCategorySeq(moyeoraDto.getSubCategorySeq());//거기에 받은 시퀀스를 박고
        moyeoraEntity.setSubCategoryEntity(subCategoryEntity);//그걸 세이브 할 moyeoraEntity에 장착
        ////이런 느낌이고 toEntity에서 해줘도 될듯 아님 그냥 여기서 해도 되고



        // 1. 모여라 Insert
        moyeoraEntity = moyeoraRepository.save(moyeoraEntity);

        MoyeoraInfoEntity moyeoraInfoEntity = MoyeoraInfoEntity.toEntity(moyeoraInfoDto);
        moyeoraInfoEntity.setMyrSeq(moyeoraEntity.getMyrSeq());
        // 2. 모여라 상세 Insert
        moyeoraInfoEntity = moyeoraInfoRepository.save(moyeoraInfoEntity);

        MoyeoraPlaceEntity moyeoraPlaceEntity = MoyeoraPlaceEntity.toEntity(moyeoraPlaceDto);
        moyeoraPlaceEntity.setMyrSeq(moyeoraEntity.getMyrSeq());
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


    public List<MoyeoraDto> selectActiveMoyeora(String nickName){
        List<MoyeoraMemberEntity> moyeoraMemberEntityList= moyeoraMemberRepository.findAllByMemberNickName(nickName);
        List<MoyeoraDto> moyeoraDtoList = new ArrayList<>();
        for(int i=0;i<moyeoraMemberEntityList.size();i++){
          MoyeoraEntity moyeoraEntity =moyeoraMemberEntityList.get(i).getMoyeora();
          MoyeoraDto moyeoraDto = new MoyeoraDto();
          moyeoraDto.setMyrSeq(moyeoraEntity.getMyrSeq());
          moyeoraDto.setMyrTags(moyeoraEntity.getMyrTags());
          moyeoraDto.setMyrMainImg(moyeoraEntity.getMyrMainImg());
          moyeoraDto.setMyrTitle(moyeoraEntity.getMyrTitle());
          moyeoraDto.setMyrMaxMember(moyeoraEntity.getMyrMaxMember());
          moyeoraDto.setCategoryName(moyeoraEntity.getSubCategoryEntity().getCategoryEntity().getCategoryName());
          moyeoraDto.setSubCategoryName(moyeoraEntity.getSubCategoryEntity().getSubCategoryName());
          moyeoraDtoList.add(moyeoraDto);

        }

       return moyeoraDtoList;
    }


}