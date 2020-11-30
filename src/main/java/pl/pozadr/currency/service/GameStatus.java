package pl.pozadr.currency.service;

import pl.pozadr.currency.model.Currency;

public class GameStatus {
    private String message;
    private Double randomToPlnRate;
    private Currency randomCurrency;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Double getRandomToPlnRate() {
        return randomToPlnRate;
    }

    public String getRandomToPlnRateString() {
        return randomToPlnRate.toString();
    }

    public void setRandomToPlnRate(Double randomToPlnRate) {
        this.randomToPlnRate = randomToPlnRate;
    }

    public Currency getRandomCurrency() {
        return randomCurrency;
    }

    public String getRandomCurrencyString() {
        return randomCurrency.toString();
    }

    public void setRandomCurrency(Currency randomCurrency) {
        this.randomCurrency = randomCurrency;
    }
}
