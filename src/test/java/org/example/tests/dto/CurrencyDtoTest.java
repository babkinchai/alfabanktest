package org.example.tests.dto;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.tests.config.FeingMocks;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.HashMap;

import static java.nio.charset.Charset.defaultCharset;
import static org.springframework.util.StreamUtils.copyToString;
@SpringBootTest
class CurrencyDtoTest {
    @Test
    void CurrencyDtoTest() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        String str=copyToString(
                FeingMocks.class.getClassLoader().getResourceAsStream("payload/get-currency-response-03.12.2021.json"),
                defaultCharset());
        CurrencyDto currencyDto=new CurrencyDto(new HashMap<>(){{put("AUD", 4.672914);}});
        CurrencyDto currencyDtoControl=objectMapper.readValue(str, CurrencyDto.class);
        Assertions.assertEquals(currencyDto,currencyDtoControl);

    }

}