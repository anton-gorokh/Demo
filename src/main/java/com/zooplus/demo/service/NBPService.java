package com.zooplus.demo.service;

public interface NBPService {
    /* GET /api/exchange-rates/{currencyCode} - returns currency exchange rate PLN to {currencyCode}
    for the last 5 business days. */
    String getPLNtoCurrencyExchangeRate(String currencyCode);

    /* GET /api/gold-price/average - returns average gold price for the last 14 business days */
    String getAvgGoldPrice();
}
