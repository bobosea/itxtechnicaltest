package com.example.itxtechnicaltest.services;

import com.example.itxtechnicaltest.model.PriceDO;
import com.example.itxtechnicaltest.ports.PriceService;
import com.example.itxtechnicaltest.mappers.GetPriceResponseDtoMapper;
import com.example.itxtechnicaltest.model.GetPriceResponseDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class PriceApiServiceImpl implements PriceApiService {

    private PriceService priceService;
    private GetPriceResponseDtoMapper getPriceResponseDtoMapper;

    public PriceApiServiceImpl(PriceService priceService, GetPriceResponseDtoMapper getPriceResponseDtoMapper) {
        this.priceService = priceService;
        this.getPriceResponseDtoMapper = getPriceResponseDtoMapper;
    }

    public Optional<GetPriceResponseDto> getPrice(LocalDateTime applicationDate, Integer productId, Integer brandId) {

        final Optional<PriceDO> getPriceResponseDto = priceService.getPrice(applicationDate, productId, brandId);

        return getPriceResponseDto.isPresent()
                ?   Optional.of(getPriceResponseDtoMapper.DOToDto(getPriceResponseDto.get()))
                :   Optional.empty();
    }
}
