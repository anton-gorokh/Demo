package com.zooplus.demo.controller;

import com.zooplus.demo.domain.ExchangeRate;
import com.zooplus.demo.service.NBPService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
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
        try {
            List<ExchangeRate> rates = nbpService.getPlnToCurrencyExchangeRates(currencyCode, 5);

            ModelAndView modelAndView = new ModelAndView("plnToCurrency");
            modelAndView.addObject("dates", rates.stream().map(ExchangeRate::getDate)
                    .collect(Collectors.toList()));
            modelAndView.addObject("prices", rates.stream().map(x -> x.getPrice().doubleValue())
                    .collect(Collectors.toList()));
            return modelAndView;
        } catch (IOException e) {
            e.printStackTrace();
            return new ModelAndView("error");
        }
    }

    @GetMapping("/gold-price/average")
    public ModelAndView getAvgGoldPrice() {
        try {
            ModelAndView modelAndView = new ModelAndView("avgGoldPrice");
            modelAndView.addObject("price", nbpService.getAvgGoldPrice(14));
            return modelAndView;
        } catch (IOException e) {
            e.printStackTrace();
            return new ModelAndView("error");
        }
    }
}
