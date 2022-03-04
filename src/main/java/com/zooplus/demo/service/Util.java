package com.zooplus.demo.service;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@FieldDefaults(level = AccessLevel.PUBLIC, makeFinal = true)
public class Util {
    // %s - currency 3 letters code, %d - N last business days
    static String CURRENCY_TO_PLN_EXCHANGE_RATE_REQ_JSON
            = "https://api.nbp.pl/api/exchangerates/rates/a/%s/last/%d/?format=json";

    // %d - N last business days
    static String AVG_GOLD_PRICE_REQ_JSON
            = "https://api.nbp.pl/api/cenyzlota/last/%d/?format=json";

    public static JSONArray getJSONArrayFromReq(String request) throws IOException {
        JSONArray jsonArray = new JSONArray(getJsonStringFromReq(request));
        return jsonArray;
    }

    public static JSONObject getJSONObjectFromReq(String request) throws IOException {
        JSONObject jsonObject = new JSONObject(getJsonStringFromReq(request));
        return jsonObject;
    }

    private static String getJsonStringFromReq(String request) throws IOException {
        InputStream responseStream;
        URL url = new URL(request);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        responseStream = connection.getInputStream();

        String jsonString = new String(responseStream.readAllBytes(), StandardCharsets.UTF_8);
        return jsonString;
    }
}
