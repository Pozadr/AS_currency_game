package pl.pozadr.currency.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.pozadr.currency.controller.thymeleaf.UserInput;
import pl.pozadr.currency.model.ConversionRates;
import pl.pozadr.currency.model.Currency;
import pl.pozadr.currency.model.CurrencyLive;

import java.util.*;

@Service
public class CurrencyService {
    private final ConversionRates currencyRates;
    private final Map<Currency, Double> currencyMap;
    private final GameStatus gameStatus;


    public CurrencyService() {
        RestTemplate restTemplateCity = new RestTemplate();
        CurrencyLive currencyLive = restTemplateCity.getForObject(
                "https://v6.exchangerate-api.com/v6/d90a998ff31d1856e56cdccf/latest/usd", CurrencyLive.class);

        assert currencyLive != null;
        currencyRates = currencyLive.getConversionRates();
        currencyMap = new HashMap<>();
        setCurrencyMap(currencyMap);

        this.gameStatus = new GameStatus();
        setStartingGameStatus();

    }

    public void checkAnswer(UserInput userInput) {
        try {
            Double rateToGuess = gameStatus.getRandomToPlnRate();
            Double inputDouble = Double.parseDouble(userInput.getInput());
            inputDouble = Math.round(inputDouble * 100.0) / 100.0;

            if (inputDouble.equals(rateToGuess)) {
                gameStatus.setMessage("Congratulations! You won!");
            } else if (inputDouble > rateToGuess) {
                gameStatus.setMessage("Too much. Try again!");
            } else {
                gameStatus.setMessage("Too little! Try again!");
            }
        } catch (ArithmeticException ex) {
            System.out.println(ex.getMessage());
            gameStatus.setMessage("Wrong input! Type number!");
        }
    }

    public Double getRandomToPlnRate(Currency random) {
        Double randomRate = currencyMap.get(random);
        Double plnRate = currencyMap.get(Currency.PLN);

        try {
            double plnToRandom = plnRate / randomRate;
            return Math.round(plnToRandom * 100.0) / 100.0;
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
        }
        return 0.0;
    }


    public Currency getRandomCurrency() {
        Object[] keys = currencyMap.keySet().toArray();
        Object key = keys[new Random().nextInt(keys.length)];
        return (Currency) key;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    private void setStartingGameStatus() {
        gameStatus.setRandomCurrency(getRandomCurrency());
        gameStatus.setRandomToPlnRate(getRandomToPlnRate(gameStatus.getRandomCurrency()));
        gameStatus.setMessage("Let's START!");
    }

    private void setCurrencyMap(Map<Currency, Double> currencyMap) {
        currencyMap.put(Currency.AED, currencyRates.getAED());
        currencyMap.put(Currency.ARS, currencyRates.getARS());
        currencyMap.put(Currency.AUD, currencyRates.getAUD());
        currencyMap.put(Currency.BGN, currencyRates.getBGN());
        currencyMap.put(Currency.BRL, currencyRates.getBRL());
        currencyMap.put(Currency.BSD, currencyRates.getBSD());
        currencyMap.put(Currency.CAD, currencyRates.getCAD());
        currencyMap.put(Currency.CHF, currencyRates.getCHF());
        currencyMap.put(Currency.CLP, currencyRates.getCLP());
        currencyMap.put(Currency.CNY, currencyRates.getCNY());
        currencyMap.put(Currency.COP, currencyRates.getCOP());
        currencyMap.put(Currency.CZK, currencyRates.getCZK());
        currencyMap.put(Currency.DKK, currencyRates.getDKK());
        currencyMap.put(Currency.DOP, currencyRates.getDOP());
        currencyMap.put(Currency.EGP, currencyRates.getEGP());
        currencyMap.put(Currency.EUR, currencyRates.getEUR());
        currencyMap.put(Currency.FJD, currencyRates.getFJD());
        currencyMap.put(Currency.GBP, currencyRates.getGBP());
        currencyMap.put(Currency.GTQ, currencyRates.getGTQ());
        currencyMap.put(Currency.HKD, currencyRates.getHKD());
        currencyMap.put(Currency.HRK, currencyRates.getHRK());
        currencyMap.put(Currency.HUF, currencyRates.getHUF());
        currencyMap.put(Currency.IDR, currencyRates.getIDR());
        currencyMap.put(Currency.ILS, currencyRates.getILS());
        currencyMap.put(Currency.INR, currencyRates.getINR());
        currencyMap.put(Currency.ISK, currencyRates.getISK());
        currencyMap.put(Currency.JPY, currencyRates.getJPY());
        currencyMap.put(Currency.KRW, currencyRates.getKRW());
        currencyMap.put(Currency.KZT, currencyRates.getKZT());
        currencyMap.put(Currency.MVR, currencyRates.getMVR());
        currencyMap.put(Currency.MXN, currencyRates.getMXN());
        currencyMap.put(Currency.MYR, currencyRates.getMYR());
        currencyMap.put(Currency.NOK, currencyRates.getNOK());
        currencyMap.put(Currency.NZD, currencyRates.getNZD());
        currencyMap.put(Currency.PAB, currencyRates.getPAB());
        currencyMap.put(Currency.PEN, currencyRates.getPEN());
        currencyMap.put(Currency.PHP, currencyRates.getPHP());
        currencyMap.put(Currency.PKR, currencyRates.getPKR());
        currencyMap.put(Currency.PLN, currencyRates.getPLN());
        currencyMap.put(Currency.PYG, currencyRates.getPYG());
        currencyMap.put(Currency.RON, currencyRates.getRON());
        currencyMap.put(Currency.RUB, currencyRates.getRUB());
        currencyMap.put(Currency.SAR, currencyRates.getSAR());
        currencyMap.put(Currency.SEK, currencyRates.getSEK());
        currencyMap.put(Currency.SGD, currencyRates.getSGD());
        currencyMap.put(Currency.THB, currencyRates.getTHB());
        currencyMap.put(Currency.TRY, currencyRates.getTRY());
        currencyMap.put(Currency.TWD, currencyRates.getTWD());
        currencyMap.put(Currency.UAH, currencyRates.getUAH());
        currencyMap.put(Currency.USD, currencyRates.getUSD());
        currencyMap.put(Currency.UYU, currencyRates.getUYU());
        currencyMap.put(Currency.ZAR, currencyRates.getZAR());

    }
}
