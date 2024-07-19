package com.example.itxtechnicaltest.services;

import com.example.itxtechnicaltest.model.PriceDO;
import com.example.itxtechnicaltest.ports.PriceRepository;
import com.example.itxtechnicaltest.ports.PriceService;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class PriceServiceImpl implements PriceService {

    final private PriceRepository priceRepository;

    public PriceServiceImpl(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    public Optional<PriceDO> getPrice(LocalDateTime applicationDate, Integer productId, Integer brandId) {

        return priceRepository.findPrice(applicationDate, productId, brandId);
    }
}
