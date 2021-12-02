package org.example.tests.config;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.io.IOException;

import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static java.nio.charset.Charset.defaultCharset;
import static org.springframework.util.StreamUtils.copyToString;

public class FeingMocks {


    public static void setupMocksResponse(WireMockServer mockService) throws IOException {

        mockService.stubFor(WireMock.get(WireMock.urlPathMatching("/historical"))
                .withQueryParam("api_key",equalTo("308d9fc793734782be53255732c4f933"))
                .withQueryParam("date",equalTo("2021-12-03"))
                .withQueryParam("symbols",equalTo("AUD"))
                .willReturn(WireMock.aResponse()
                        .withStatus(HttpStatus.OK.value())
                        .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                        .withBody(copyToString(
                                FeingMocks.class.getClassLoader().getResourceAsStream("payload/get-currency-response-03.12.2021.json"),
                                defaultCharset())
                                )));
        mockService.stubFor(WireMock.get(WireMock.urlPathMatching("/historical"))
                .withQueryParam("api_key",equalTo("308d9fc793734782be53255732c4f933"))
                .withQueryParam("date",equalTo("2021-12-02"))
                .withQueryParam("symbols",equalTo("AUD"))
                .willReturn(WireMock.aResponse()
                        .withStatus(HttpStatus.OK.value())
                        .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                        .withBody(copyToString(
                                FeingMocks.class.getClassLoader().getResourceAsStream("payload/get-currency-response-02.12.2021.json"),
                                defaultCharset())
                        )));
        mockService.stubFor(WireMock.get(WireMock.urlPathMatching("/v1/gifs/random"))
                .withQueryParam("api_key",equalTo("ZfCK5y6hUnrOFOz84olUCI7bqJver9Th"))
                .withQueryParam("tag",equalTo("rich"))
                .willReturn(WireMock.aResponse()
                        .withStatus(HttpStatus.OK.value())
                        .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                        .withBody(copyToString(
                                FeingMocks.class.getClassLoader().getResourceAsStream("payload/gif.json"),
                                defaultCharset()))
                        ));
    }
}
