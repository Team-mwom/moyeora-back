package com.mwom.moyeora.database.repository;

import com.mwom.moyeora.database.entity.Moyeora;
import com.mwom.moyeora.database.entity.MoyeoraInfo;
import com.mwom.moyeora.database.entity.MoyeoraPlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoyeoraPlaceRepository extends JpaRepository<MoyeoraPlace, Long> {

    MoyeoraPlace save(MoyeoraPlace moyeoraPlace);

}
