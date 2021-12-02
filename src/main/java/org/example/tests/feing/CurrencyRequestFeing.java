package org.example.tests.feing;


import org.example.tests.dto.CurrencyDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "${currency.service.url}",value = "currency-client", primary = false)
public interface CurrencyRequestFeing {

    @GetMapping(value = "/historical?api_key=${currency.service.appid}")
    CurrencyDto getExchangeRatesHistorical (
            @RequestParam("date") String date,
            @RequestParam("symbols") String symbol
    );
}
