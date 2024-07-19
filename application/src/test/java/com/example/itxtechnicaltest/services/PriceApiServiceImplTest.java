package com.example.itxtechnicaltest.services;

import com.example.itxtechnicaltest.model.PriceDO;
import com.example.itxtechnicaltest.ports.PriceService;
import com.example.itxtechnicaltest.mappers.GetPriceResponseDtoMapper;
import com.example.itxtechnicaltest.model.GetPriceResponseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

public class PriceApiServiceImplTest {

    private PriceApiServiceImpl priceApiServiceImpl;

    @Mock
    private PriceService priceService;

    @Mock
    private GetPriceResponseDtoMapper getPriceResponseDtoMapper;

    @BeforeEach
    public void before() {
        MockitoAnnotations.openMocks(this);
        priceApiServiceImpl = new PriceApiServiceImpl(priceService, getPriceResponseDtoMapper);
    }

    @Test
    public void getPriceWhenEmptyRequestThenEmptyResponse() {

        doReturn(Optional.empty()).when(priceService).getPrice(any(), any(), any());

        Optional<GetPriceResponseDto> getPriceResponseDto = priceApiServiceImpl.getPrice(LocalDateTime.now(), 1, 1);

        assertTrue(getPriceResponseDto.isEmpty());
    }

    @Test
    public void getPriceWhenNoEmptyResultThenNoEmptyResultAndOk() throws Exception {

        doReturn(Optional.of(new PriceDO(null, null, null, null, null, null)))
                .when(priceService).getPrice(any(), any(), any());
        doReturn(new GetPriceResponseDto(null, null, null, null, null, null))
                .when(getPriceResponseDtoMapper).DOToDto(any());

        Optional<GetPriceResponseDto> getPriceResponseDto = priceApiServiceImpl.getPrice(LocalDateTime.now(), 1, 1);

        assertFalse(getPriceResponseDto.isEmpty());
    }
}
