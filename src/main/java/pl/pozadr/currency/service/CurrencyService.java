package pl.pozadr.currency.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.pozadr.currency.model.CurrencyLive;

@Service
public class CurrencyService {
    private CurrencyLive currencyRates;

    public CurrencyService() {
        RestTemplate restTemplateCity = new RestTemplate();
        currencyRates = restTemplateCity.getForObject(
                "https://v6.exchangerate-api.com/v6/d90a998ff31d1856e56cdccf/latest/usd", CurrencyLive.class);
        }

    public CurrencyLive getCurrencyRates() {
        return currencyRates;
    }

    public void setCurrencyRates(CurrencyLive currencyRates) {
        this.currencyRates = currencyRates;
    }
}
