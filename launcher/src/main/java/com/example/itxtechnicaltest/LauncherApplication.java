package com.example.itxtechnicaltest;

import com.example.itxtechnicaltest.mappers.GetPriceResponseDtoMapper;
import com.example.itxtechnicaltest.mappers.GetPriceResponseDtoMapperImpl;
import com.example.itxtechnicaltest.mappers.PriceMapper;
import com.example.itxtechnicaltest.mappers.PriceMapperImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LauncherApplication {

    public static void main(String[] args) {
        SpringApplication.run(LauncherApplication.class, args);
    }

    @Bean
    public PriceMapper getPriceMapper() {
        return new PriceMapperImpl();
    }

    @Bean
    public GetPriceResponseDtoMapper getGetPriceResponseDtoMapper() {
        return new GetPriceResponseDtoMapperImpl();
    }

}