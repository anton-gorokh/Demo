package com.zooplus.demo.controller;

import com.zooplus.demo.service.NBPService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NBPController {
    final
    NBPService nbpService;

    @GetMapping("/exchange-rates/{currencyCode}")
    public ModelAndView getPLNtoCurrencyExchangeRate(@PathVariable String currencyCode) {
        List<Float> plNtoCurrencyExchangeRate = nbpService.getPLNtoCurrencyExchangeRate(currencyCode, 5);
        List<String> rates = plNtoCurrencyExchangeRate.stream()
                .map(String::valueOf).collect(Collectors.toList());

        ModelAndView modelAndView = new ModelAndView("pln-to-cur");
        modelAndView.addObject("list", rates);
        return modelAndView;
    }

    @GetMapping("/gold-price/average")
    public String getAvgGoldPrice() {
        return String.format("Average gold price for the last 14 business days is: %.2f pln",
                nbpService.getAvgGoldPrice(14));
    }
}
