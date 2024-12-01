package com.mwom.moyeora.category.service;


import com.mwom.moyeora.database.entity.OrgEntity;
import com.mwom.moyeora.database.repository.OrgRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrgService {

    @Autowired
    private final OrgRepository orgRepository;

    /**
     * 시도 전체 검색
     * CategoryService.selectCategoryList
     * @return List<CategoryEntity>
     */
    public List<OrgEntity> selectSidoList(String CdDelYn, String OrgClsCd){
        return orgRepository.findByCdDelYnAndOrgClsCd(CdDelYn, OrgClsCd);
    }

    /**
     * 시군구 전체 검색
     * CategoryService.selectCategoryList
     * @return List<CategoryEntity>
     */
    public List<OrgEntity> selectSigunguList(String CdDelYn, String OrgClsCd){
        return orgRepository.findByCdDelYnAndOrgClsCd(CdDelYn, OrgClsCd);
    }
}
