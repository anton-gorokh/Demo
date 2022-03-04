package com.zooplus.demo.service;

import lombok.NoArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@NoArgsConstructor
public class NBPServiceImpl implements NBPService {
    // You can find methods description in service/NBPService

    /* GET /api/exchange-rates/{currencyCode} - returns currency exchange rate PLN to {currencyCode}
    for the last 5 business days. */
    @Override
    public List<Float> getPLNtoCurrencyExchangeRate(String currencyCode, int businessDays) {
        JSONObject jsonObject;
        try {
            jsonObject = Util.getJSONObjectFromReq(
                    String.format(Util.CURRENCY_TO_PLN_EXCHANGE_RATE_REQ_JSON, currencyCode, businessDays));
        } catch (IOException e) {
            return null;
        }
        JSONArray rates = jsonObject.getJSONArray("rates");
        List<Float> result = new ArrayList<>();

        for(int i = 0; i < rates.length(); i++) {
            // Currency to PLN
            float plnRate = rates.getJSONObject(i).getFloat("mid");
            // PLN to Currency
            float curRate = 1 / plnRate;

            result.add(curRate);
        }
        return result;
    }

    /* GET /api/gold-price/average - returns average gold price for the last 14 business days */
    @Override
    public float getAvgGoldPrice(int businessDays) {
        JSONArray jsonArray;
        try {
            jsonArray = Util.getJSONArrayFromReq(String.format(Util.AVG_GOLD_PRICE_REQ_JSON, businessDays));
        } catch (IOException e) {
            return -1;
        }

        float sum = 0;
        for(int i = 0; i < jsonArray.length(); i++) {
            sum += jsonArray.getJSONObject(i).getFloat("cena");
        }
        float avg = sum / jsonArray.length();
        return avg;
    }
}
