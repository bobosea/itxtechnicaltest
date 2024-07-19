package com.example.itxtechnicaltest.adapters;

import com.example.itxtechnicaltest.ports.PriceRepository;
import com.example.itxtechnicaltest.jpa.repositories.PriceCrudRepository;
import com.example.itxtechnicaltest.mappers.PriceMapper;
import com.example.itxtechnicaltest.model.PriceDO;
import org.springframework.data.domain.Limit;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class PriceRepositoryAdapter implements PriceRepository {

    private PriceCrudRepository priceCrudRepository;
    private PriceMapper priceMapper;

    public PriceRepositoryAdapter(PriceCrudRepository priceCrudRepository, PriceMapper priceMapper) {
        this.priceCrudRepository = priceCrudRepository;
        this.priceMapper = priceMapper;
    }

    public Optional<PriceDO> findPrice(LocalDateTime applicationDate, Integer productId, Integer brandId) {

        return priceCrudRepository
                .findByApplicationDateAndProductIdAndBrandIdAndTopPriority(applicationDate, productId, brandId, Limit.of(1))
                .stream().map(priceMapper::entityToDO).findAny();
    }
}
