package com.zooplus.demo.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zooplus.demo.domain.ExchangeRate;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;

@FieldDefaults(level = AccessLevel.PUBLIC, makeFinal = true)
public class Util {
    /**
     * Http request to get a table of currency (%s) to pln exchange rates
     * for the last %d business days.
     */
    static String CURRENCY_TO_PLN_EXCHANGE_RATE_REQ_JSON
            = "https://api.nbp.pl/api/exchangerates/rates/a/%s/last/%d/?format=json";

    /**
     * Http request to get an array of gold price to pln exchange rates
     * for the last %d business days.
     */
    static String AVG_GOLD_PRICE_REQ_JSON
            = "https://api.nbp.pl/api/cenyzlota/last/%d/?format=json";

    /**
     * Maps json array into exchange rates
     * @param json json string to parse
     * @return list of mapped exchange rates
     * @throws JsonProcessingException if json string is incorrect
     */
    public static List<ExchangeRate> mapJsonArrayToExchangeRate(String json) throws JsonProcessingException {
        return new ObjectMapper().readValue(
                json,
                new TypeReference<>() {
                });
    }

    /**
     * Maps json table into exchange rates
     * @param json json string to parse
     * @return list of mapped exchange rates
     * @throws JsonProcessingException if json string is incorrect
     */
    public static List<ExchangeRate> mapJsonCurrencyTableToExchangeRate(String json) throws JsonProcessingException {
        JSONObject jsonObject = new JSONObject(json);
        String ratesArray = jsonObject.getJSONArray("rates").toString();
        return mapJsonArrayToExchangeRate(ratesArray);
    }

    /**
     * Returns the response from http/s request
     * @param request http request
     * @return response from request
     */
    public static String getStringFromHttpReq(String request) throws IOException {
        URL url = new URL(request);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        InputStream responseStream = connection.getInputStream();
        return new String(responseStream.readAllBytes(), StandardCharsets.UTF_8);
    }
}
