package com.mwom.moyeora.database.repository;

import com.mwom.moyeora.database.dto.MoyeoraPlaceDto;
import com.mwom.moyeora.database.entity.MoyeoraPlaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoyeoraPlaceRepository extends JpaRepository<MoyeoraPlaceEntity, Long> {

    MoyeoraPlaceEntity save(MoyeoraPlaceEntity moyeoraPlaceEntity);

}
