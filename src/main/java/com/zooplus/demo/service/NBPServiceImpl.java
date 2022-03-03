package com.zooplus.demo.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.Calendar;

@Service
@NoArgsConstructor
public class NBPServiceImpl implements NBPService {
    // You can find methods description in service/NBPService

    /* GET /api/exchange-rates/{currencyCode} - returns currency exchange rate PLN to {currencyCode}
    for the last 5 business days. */
    @Override
    public String getPLNtoCurrencyExchangeRate(String currencyCode) {
        /*TODO
        Request with Util.GET_CURRENCY_TO_PLN_EXCHANGE_RATE_REQ
         */
        return null;
    }

    /* GET /api/gold-price/average - returns average gold price for the last 14 business days */
    @Override
    public String getAvgGoldPrice() {
        /*TODO
        Request with Util.GET_AVG_GOLD_PRICE_REQ
         */
        return null;
    }

    // Returns date in format "YYYY-MM-DD"
    private String calculateDateByBusinessDays(int businessDaysAgo) {
        Calendar calendar = Calendar.getInstance();

        while (businessDaysAgo > 0) {
            calendar.add(Calendar.DAY_OF_WEEK, -1);

            if (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY
            && calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY) {
                businessDaysAgo--;
            }
        }

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return dtf.format(calendar.toInstant());
    }
}
