package org.example.tests.services;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.example.tests.config.FeingMocks;
import org.example.tests.config.WireMockConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;

@SpringBootTest
@ActiveProfiles("test")
@EnableConfigurationProperties
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { WireMockConfig.class })
class CurrencyServiceTest {

    @Autowired
    private WireMockServer mockService;

    @Autowired
    private CurrencyService currencyService;

    @BeforeEach
    void setUp() throws IOException {
        FeingMocks.setupMocksResponse(mockService);
    }

    @Test
    void getGifByExchangeRates() {
    }

    @Test
    void currencyGrow() {
        Assertions.assertTrue(currencyService.currencyGrow("AUD"));
    }
}