package org.example.tests.feing;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.example.tests.config.FeingMocks;
import org.example.tests.config.WireMockConfig;
import org.example.tests.dto.GifDto;
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
class GifRequestFeingTest {

    @Autowired
    private WireMockServer mockBooksService;

    @Autowired
    private GifRequestFeing gifRequestFeing;

    @BeforeEach
    void setUp() throws IOException {
        FeingMocks.setupMocksResponse(mockBooksService);
    }

    @Test
    public void whenGetGifRichBeReturned() {
        GifDto gifDtoControl=new GifDto();
        gifDtoControl.setUrl("https://media4.giphy.com/media/AVvKQFfLhrVS6p0NLX/giphy.gif?cid=9aece108dfd592f876553afe7cff87ae4cccba6ae6d4ef19&rid=giphy.gif&ct=g");
        GifDto gifDto=gifRequestFeing.getRichTag();
        Assertions.assertEquals(gifDto,gifDtoControl);
    }


}