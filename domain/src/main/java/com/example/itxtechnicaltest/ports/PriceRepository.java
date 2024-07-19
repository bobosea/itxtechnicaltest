package com.example.itxtechnicaltest.ports;

import com.example.itxtechnicaltest.model.PriceDO;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceRepository {

    Optional<PriceDO> findPrice(LocalDateTime applicationDate, Integer productId, Integer brandId);
}
