package com.mwom.moyeora.main;

import com.mwom.moyeora.database.entity.MoyeoraEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@RequiredArgsConstructor
public class MainCustomRepositoryImpl implements MainCustomRepository {
    private final EntityManager entityManager;

    @Override
    public Page<MoyeoraEntity> selectMoyeoraList(Pageable pageable) {

        String queryStr = "SELECT m FROM MoyeoraEntity m ORDER BY m.regDt DESC";
        TypedQuery<MoyeoraEntity> query = entityManager.createQuery(queryStr, MoyeoraEntity.class);
        query.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
        query.setMaxResults(pageable.getPageSize());
        List<MoyeoraEntity> moyeoraList = query.getResultList();

        String countQueryStr = "SELECT COUNT(m) FROM MoyeoraEntity m";
        long totalRecords = entityManager.createQuery(countQueryStr, Long.class)
                .getSingleResult();

        return new PageImpl<>(moyeoraList, pageable, totalRecords);
    }
}
