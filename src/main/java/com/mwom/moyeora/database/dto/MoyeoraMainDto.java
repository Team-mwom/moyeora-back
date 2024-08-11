package com.mwom.moyeora.database.dto;

import com.mwom.moyeora.database.entity.Moyeora;
import com.mwom.moyeora.database.entity.MoyeoraInfo;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.OneToOne;

@Data
@Builder
public class MoyeoraMainDto {

    private Moyeora moyeora;

    private MoyeoraInfo moyeoraInfo;
}
