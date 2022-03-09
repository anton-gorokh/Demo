package com.zooplus.demo.service;

import com.zooplus.demo.domain.ExchangeRate;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Service
@NoArgsConstructor
public class NBPServiceImpl implements NBPService {
    @Override
    public List<ExchangeRate> getCurrencyToPlnExchangeRates(String currencyCode, int businessDays) throws IOException {
        return Util.mapJsonCurrencyTableToExchangeRate(
                Util.getStringFromHttpReq(
                        String.format(Util.CURRENCY_TO_PLN_EXCHANGE_RATE_REQ_JSON, currencyCode, businessDays)
                )
        );
    }

    @Override
    public List<ExchangeRate> getPlnToCurrencyExchangeRates(String currencyCode, int businessDays) throws IOException {
        List<ExchangeRate> rates = Util.mapJsonCurrencyTableToExchangeRate(
                Util.getStringFromHttpReq(
                        String.format(Util.CURRENCY_TO_PLN_EXCHANGE_RATE_REQ_JSON, currencyCode, businessDays)
                )
        );

        // Flips currencies by dividing 1 by rate
        rates.forEach(x -> {
            x.setPrice(BigDecimal.valueOf(1 / x.getPrice().doubleValue()));
        });
        return rates;
    }

    @Override
    public double getAvgGoldPrice(int businessDays) throws IOException {
        List<ExchangeRate> rates = Util.mapJsonArrayToExchangeRate(
                Util.getStringFromHttpReq(
                        String.format(Util.AVG_GOLD_PRICE_REQ_JSON, businessDays)
                )
        );

        return rates.stream().filter(Objects::nonNull)
                .mapToDouble(x -> x.getPrice()
                        .doubleValue()).average().getAsDouble();
    }
}
