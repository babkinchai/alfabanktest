package org.example.tests.dto;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.tests.config.FeingMocks;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static java.nio.charset.Charset.defaultCharset;
import static org.springframework.util.StreamUtils.copyToString;

@SpringBootTest
class gifDtoTest {


    @Test
    void gifDtoTest() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        String str=copyToString(
                FeingMocks.class.getClassLoader().getResourceAsStream("payload/gif.json"),
                defaultCharset());
        GifDto gifDtoControl=new GifDto();
        gifDtoControl.setUrl("https://media4.giphy.com/media/AVvKQFfLhrVS6p0NLX/giphy.gif?cid=9aece108dfd592f876553afe7cff87ae4cccba6ae6d4ef19&rid=giphy.gif&ct=g");
        GifDto gifDto=objectMapper.readValue(str, GifDto.class);
        Assertions.assertEquals(gifDto,gifDtoControl);

    }
}