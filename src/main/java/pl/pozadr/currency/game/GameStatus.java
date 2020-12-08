package pl.pozadr.currency.game;

import org.springframework.stereotype.Component;
import pl.pozadr.currency.model.currency.Currency;

@Component
public class GameStatus {
    private String message;
    private Double randomToPlnRate;
    private Currency randomCurrency;
    private boolean winner;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Double getRandomToPlnRate() {
        return randomToPlnRate;
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

    public boolean isWinner() {
        return winner;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }
}
