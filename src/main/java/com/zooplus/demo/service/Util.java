package com.zooplus.demo.service;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PUBLIC, makeFinal = true)
public class Util {
    // currency, date from, date to
    static String GET_CURRENCY_TO_PLN_EXCHANGE_RATE_REQ
            = "https://api.nbp.pl/api/exchangerates/rates/a/%s/%s/%s/";
    // date from, date to
    static String GET_AVG_GOLD_PRICE_REQ
            = "https://api.nbp.pl/api/cenyzlota/%s/%s/";
}
