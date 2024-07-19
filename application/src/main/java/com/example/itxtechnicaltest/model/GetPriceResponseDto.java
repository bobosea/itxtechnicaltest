package com.example.itxtechnicaltest.model;

import java.time.LocalDateTime;

public record GetPriceResponseDto(Long productId, Integer brandId, Long priceList, LocalDateTime startDate, LocalDateTime endDate, Double price) {
}
