package pl.pozadr.currency.repository;

import pl.pozadr.currency.model.currency.Currency;
import pl.pozadr.currency.model.currency.CurrencyLive;

import java.util.Map;

public interface CurrencyGameRepository {
    void initRepository(CurrencyLive currencyLive);
    Map<Currency, Double> getCurrencyMap();
}
