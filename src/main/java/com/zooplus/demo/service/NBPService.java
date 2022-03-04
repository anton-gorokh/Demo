package com.zooplus.demo.service;

import java.util.List;

public interface NBPService {
    /* GET /api/exchange-rates/{currencyCode} - returns currency exchange rate PLN to {currencyCode}
    for the last 5 business days. */
    List<Float> getPLNtoCurrencyExchangeRate(String currencyCode, int businessDays);

    /* GET /api/gold-price/average - returns average gold price for the last 14 business days */
    float getAvgGoldPrice(int businessDays);
}
