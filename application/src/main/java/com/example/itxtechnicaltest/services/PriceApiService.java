package com.example.itxtechnicaltest.services;

import com.example.itxtechnicaltest.model.GetPriceResponseDto;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceApiService {

    Optional<GetPriceResponseDto> getPrice(LocalDateTime applicationDate, Integer productId, Integer brandId);
}
