package com.mwom.moyeora.database.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MoyeoraMainDto {

    private MoyeoraDto moyeoraDto;

    private MoyeoraInfoDto moyeoraInfoDto;

    private MoyeoraPlaceDto moyeoraPlaceDto;
}
