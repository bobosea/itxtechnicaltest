package com.example.itxtechnicaltest.controllers;

import com.example.itxtechnicaltest.model.GetPriceResponseDto;
import com.example.itxtechnicaltest.services.PriceApiServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

public class PriceControllerTest {

    private PriceController priceController;

    @Mock
    private PriceApiServiceImpl priceApiService;

    @BeforeEach
    public void before() {
        MockitoAnnotations.openMocks(this);
        priceController = new PriceController(priceApiService);
    }

    @Test
    public void getPriceWhenEmptyRequestThenEmptyResponse() {

        doReturn(Optional.empty()).when(priceApiService).getPrice(any(), any(), any());

        ResponseEntity<GetPriceResponseDto> result = priceController.getPrice(LocalDateTime.now(), 1, 1);

        assertEquals(result.getStatusCode(), HttpStatus.NOT_FOUND);
    }

    @Test
    public void getPriceWhenNoEmptyResultThenNoEmptyResultAndOk() throws Exception {

        doReturn(Optional.of(new GetPriceResponseDto(null, null, null, null, null, null)))
                .when(priceApiService).getPrice(any(), any(), any());

        ResponseEntity<GetPriceResponseDto> result = priceController.getPrice(LocalDateTime.now(), 1, 1);

        assertEquals(result.getStatusCode(), HttpStatus.OK);
    }
}
