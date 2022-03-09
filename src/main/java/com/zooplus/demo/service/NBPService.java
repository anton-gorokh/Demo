package com.zooplus.demo.service;

import com.zooplus.demo.domain.ExchangeRate;

import java.io.IOException;
import java.util.List;

public interface NBPService {
    /**
     * Returns the list of pln to currency exchange rates for n last business days
     * @param currencyCode 3 letter currency code
     * @param businessDays the number of last business days to check
     * @return the list of exchange rates for last n business days
     * @throws IOException
     */
    List<ExchangeRate> getPlnToCurrencyExchangeRates(String currencyCode, int businessDays) throws IOException;

    /**
     * Returns the list of currency to pln exchange rates for n business days
     * @param currencyCode 3 letter currency code
     * @param businessDays the number of last business days to check
     * @return the list of exchange rates for last n business days
     * @throws IOException
     */
    List<ExchangeRate> getCurrencyToPlnExchangeRates(String currencyCode, int businessDays) throws IOException;

    /**
     * Returns the average gold price for n last business days
     * @param businessDays the number of last business days to check
     * @return the average price
     * @throws IOException
     */
    double getAvgGoldPrice(int businessDays) throws IOException;
}
