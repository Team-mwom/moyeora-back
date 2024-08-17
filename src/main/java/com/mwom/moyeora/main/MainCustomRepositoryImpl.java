package com.mwom.moyeora.main;

import com.mwom.moyeora.database.entity.MoyeoraEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import java.util.List;

@RequiredArgsConstructor
public class MainCustomRepositoryImpl implements MainCustomRepository {
    private final EntityManager entityManager;

    @Override
    public Page<MoyeoraEntity> selectMoyeoraList(Pageable pageable) {

        List<MoyeoraEntity> moyeoraList  = entityManager.createQuery("SELECT m FROM MoyeoraEntity m", MoyeoraEntity.class)
                .setFirstResult(pageable.getPageNumber() * pageable.getPageSize())
                .setMaxResults(pageable.getPageSize())
                .getResultList();

        // 페이징 정보 설정
        long count = entityManager.createQuery("SELECT COUNT(m) FROM MoyeoraEntity m", Long.class)
                .getSingleResult();

        return new PageImpl<>(moyeoraList, pageable, count);
    }
}
