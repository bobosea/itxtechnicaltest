package com.example.itxtechnicaltest;

import com.example.itxtechnicaltest.controllers.PriceController;
import com.example.itxtechnicaltest.model.GetPriceResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.time.Month;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PriceControllerIntegrationTest {

    @Autowired
    private PriceController priceController;

    @Test
    void getPriceWhenNonEmptyResponseThenOK() {

        ResponseEntity<GetPriceResponseDto> response =
                priceController.getPrice(LocalDateTime.of(2020, Month.JUNE, 14, 0, 0, 0), 35455, 1);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().priceList()).isEqualTo(1);
    }

    @Test
    void getPriceWhenEmptyResponseThenNoFound() {

        ResponseEntity<GetPriceResponseDto> response =
                priceController.getPrice(LocalDateTime.of(2021, Month.JUNE, 14, 0, 0, 0), 35455, 1);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
        assertThat(response.getBody()).isNull();
    }
}
