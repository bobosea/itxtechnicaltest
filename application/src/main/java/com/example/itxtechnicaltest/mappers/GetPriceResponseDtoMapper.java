package com.example.itxtechnicaltest.mappers;

import com.example.itxtechnicaltest.model.PriceDO;
import com.example.itxtechnicaltest.model.GetPriceResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GetPriceResponseDtoMapper {

    GetPriceResponseDtoMapper INSTANCE = Mappers.getMapper(GetPriceResponseDtoMapper.class);

    GetPriceResponseDto DOToDto(PriceDO priceDO);
}
