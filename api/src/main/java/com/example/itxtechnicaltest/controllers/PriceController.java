package com.example.itxtechnicaltest.controllers;

import com.example.itxtechnicaltest.model.GetPriceResponseDto;
import com.example.itxtechnicaltest.services.PriceApiService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
public class PriceController {

    final private PriceApiService priceApiService;

    public PriceController(PriceApiService priceApiService) {
        this.priceApiService = priceApiService;
    }

    @GetMapping("/price")
    public ResponseEntity<GetPriceResponseDto> getPrice(
            @RequestParam(value = "applicationDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime applicationDate,
            @RequestParam(value = "productId") Integer productId,
            @RequestParam(value = "brandId") Integer brandId) {

        final Optional<GetPriceResponseDto> getPriceResponseDto = priceApiService.getPrice(applicationDate, productId, brandId);

        return getPriceResponseDto.isPresent()
                ?	ResponseEntity.ok(getPriceResponseDto.get())
                :   new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
