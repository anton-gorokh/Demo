package com.zooplus.demo.controller;

import com.zooplus.demo.service.NBPService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NBPController {
    final
    NBPService nbpService;

    @GetMapping("/exchange-rates/{currencyCode}")
    public String getPLNtoCurrencyExchangeRate(@PathVariable String currencyCode) {
        return nbpService.getPLNtoCurrencyExchangeRate(currencyCode);
    }

    @GetMapping("/gold-price/average")
    public String getAvgGoldPrice() {
        return nbpService.getAvgGoldPrice();
    }
}
