package org.example.tests.services;

import org.example.tests.dto.CurrencyDto;
import org.example.tests.feing.CurrencyRequestFeing;
import org.example.tests.feing.GifRequestFeing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class CurrencyService implements CurrencyServiceInterface{

    private final GifRequestFeing gifRequestFeing;

    private final CurrencyRequestFeing currencyRequestFeing;

    public CurrencyService(CurrencyRequestFeing currencyRequestFeing, GifRequestFeing gifRequestFeing) {
        this.currencyRequestFeing = currencyRequestFeing;
        this.gifRequestFeing = gifRequestFeing;
    }

    @Override
    public String getGifByExchangeRates(String currencyName) {
        if(currencyGrow(currencyName))
            return gifRequestFeing.getRichTag().getUrl();
        else
            return gifRequestFeing.getBrokeTag().getUrl();

    }

    boolean currencyGrow(String currencyName) {
        boolean currencyRise = false;
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime localDateTime =LocalDateTime.now();
        CurrencyDto currencyDtoToday = currencyRequestFeing.getExchangeRatesHistorical(localDateTime.format(formatters).toString(), currencyName);
        localDateTime =LocalDateTime.now().minusDays(1);
        CurrencyDto currencyDtoYesterday = currencyRequestFeing.getExchangeRatesHistorical(localDateTime.format(formatters).toString(), currencyName);
        if(currencyDtoToday.getRates().get(currencyName)>currencyDtoYesterday.getRates().get(currencyName)) {
            currencyRise = true;
        }
        return currencyRise;
    }
}
