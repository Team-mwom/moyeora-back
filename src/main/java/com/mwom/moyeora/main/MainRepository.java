package com.mwom.moyeora.main;

import com.mwom.moyeora.main.entity.SearchMainEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainRepository extends JpaRepository<SearchMainEntity, String> {

}
