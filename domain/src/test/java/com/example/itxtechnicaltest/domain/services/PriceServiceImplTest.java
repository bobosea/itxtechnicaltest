package com.example.itxtechnicaltest.domain.services;

import com.example.itxtechnicaltest.model.PriceDO;
import com.example.itxtechnicaltest.ports.PriceRepository;
import com.example.itxtechnicaltest.services.PriceServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

public class PriceServiceImplTest {

    private PriceServiceImpl priceServiceImpl;

    @Mock
    private PriceRepository priceRepository;

    @BeforeEach
    public void before() {
        MockitoAnnotations.openMocks(this);
        priceServiceImpl = new PriceServiceImpl(priceRepository);
    }

    @Test
    public void findPriceWhenEmptyRequestThenEmptyResponse() {

        doReturn(Optional.empty()).when(priceRepository).findPrice(any(), any(), any());

        Optional<PriceDO> priceBOOptional =
                priceServiceImpl.getPrice(LocalDateTime.now(), 1, 1);

        assertTrue(priceBOOptional.isEmpty());
    }

    @Test
    public void findPriceWhenNoEmptyRequestThenNoEmptyResponse() {

        doReturn(Optional.of(new PriceDO(null, null, null, null, null, null)))
                .when(priceRepository).findPrice(any(), any(), any());

        Optional<PriceDO> priceBOOptional =
                priceServiceImpl.getPrice(LocalDateTime.now(), 1, 1);

        assertFalse(priceBOOptional.isEmpty());
    }
}
