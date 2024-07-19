package com.example.itxtechnicaltest.mappers;

import com.example.itxtechnicaltest.jpa.entities.Price;
import com.example.itxtechnicaltest.model.PriceDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PriceMapper {

    PriceMapper INSTANCE = Mappers.getMapper(PriceMapper.class);

    PriceDO entityToDO(Price price);
}
