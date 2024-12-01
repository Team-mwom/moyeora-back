package com.mwom.moyeora.database.repository;

import com.mwom.moyeora.database.entity.OrgEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrgRepository extends JpaRepository<OrgEntity, Long> {

    /**
     * 시/도 및 시/군/구 조회
     * OrgRepository.selectSidoList
     * @return List<OrgEntity>
     */
    List<OrgEntity> findByCdDelYnAndOrgClsCd(String CdDelYn, String OrgClsCd);


}
