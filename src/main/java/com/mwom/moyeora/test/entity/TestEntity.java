package com.mwom.moyeora.test.entity;

import lombok.*;

import javax.persistence.*;
import javax.transaction.Transactional;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Transactional
@Table(name="test_table")
public class TestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
    private int idx;

    @Column(nullable = true, length = 100)
    private  int age;

    @Column(nullable = true, length = 100)
    private String name,family;

    @Column(nullable = true, length = 100)
    private float weight;
}
