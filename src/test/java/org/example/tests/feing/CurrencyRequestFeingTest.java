package org.example.tests.feing;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.example.tests.config.FeingMocks;
import org.example.tests.config.WireMockConfig;
import org.example.tests.controllers.MainController;
import org.example.tests.dto.CurrencyDto;
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
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@ActiveProfiles("test")
@EnableConfigurationProperties
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { WireMockConfig.class })
class CurrencyRequestFeingTest {

    @Autowired
    private CurrencyRequestFeing currencyRequestFeing;

    @Autowired
    private WireMockServer mockService;

    @BeforeEach
    void setUp() throws IOException {
        FeingMocks.setupMocksResponse(mockService);
    }

    @Test
    public void whenGetCurrency_thenCurrencyShouldBeReturned() {
        CurrencyDto currencyDto=new CurrencyDto(new HashMap<>(){{put("AUD",3.672914);}});
        Assertions.assertEquals(currencyRequestFeing.getExchangeRatesHistorical("2021-12-02","AUD"),currencyDto);
    }


}