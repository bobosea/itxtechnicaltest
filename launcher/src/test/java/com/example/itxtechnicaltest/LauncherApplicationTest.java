package com.example.itxtechnicaltest;

import com.example.itxtechnicaltest.controllers.PriceController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class LauncherApplicationTest {

    @Autowired
    private PriceController priceController;

    @Test
    void contextLoads() {
        assertNotNull(priceController);
    }
}
