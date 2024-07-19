package com.example.itxtechnicaltest.model;

import java.time.LocalDateTime;

public record PriceDO(Long productId, Integer brandId, Long priceList, LocalDateTime startDate, LocalDateTime endDate, Double price) {
}
