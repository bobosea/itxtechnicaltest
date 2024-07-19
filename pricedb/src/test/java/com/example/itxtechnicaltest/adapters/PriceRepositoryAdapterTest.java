package com.example.itxtechnicaltest.adapters;

import com.example.itxtechnicaltest.jpa.entities.Price;
import com.example.itxtechnicaltest.jpa.repositories.PriceCrudRepository;
import com.example.itxtechnicaltest.mappers.PriceMapper;
import com.example.itxtechnicaltest.model.PriceDO;
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

public class PriceRepositoryAdapterTest {

    private PriceRepositoryAdapter priceRepositoryAdapter;

    @Mock
    private PriceCrudRepository priceCrudRepository;

    @Mock
    private PriceMapper priceMapper;

    @BeforeEach
    public void before() {
        MockitoAnnotations.openMocks(this);
        priceRepositoryAdapter = new PriceRepositoryAdapter(priceCrudRepository, priceMapper);
    }

    @Test
    public void findPriceWhenNoResultThenEmptyResponse() {

        doReturn(Optional.empty()).when(priceCrudRepository).findByApplicationDateAndProductIdAndBrandIdAndTopPriority(any(), any(), any(), any());

        Optional<PriceDO> priceDOOptional = priceRepositoryAdapter.findPrice(LocalDateTime.now(), 1, 1);

        assertTrue(priceDOOptional.isEmpty());
    }

    @Test
    public void findPriceWhenResultThenNoEmptyResponse() {

        doReturn(Optional.of(new Price()))
                .when(priceCrudRepository).findByApplicationDateAndProductIdAndBrandIdAndTopPriority(any(), any(), any(), any());
        doReturn(new PriceDO(null, null, null, null, null, null))
                .when(priceMapper).entityToDO((Price) any());

        Optional<PriceDO> priceDOOptional =
                priceRepositoryAdapter.findPrice(LocalDateTime.now(), 1, 1);

        assertFalse(priceDOOptional.isEmpty());
    }
}
