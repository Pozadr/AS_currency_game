package pl.pozadr.currency.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.pozadr.currency.dto.UserInput;
import pl.pozadr.currency.game.GameStatus;
import pl.pozadr.currency.model.currency.Currency;
import pl.pozadr.currency.model.currency.CurrencyLive;
import pl.pozadr.currency.repository.CurrencyGameRepository;

import java.util.*;

@Service
public class CurrencyServiceImpl implements CurrencyService {
    @Value("${url-code}")
    private String urlUniqueCode;
    private final CurrencyGameRepository gameRepository;
    private final GameStatus gameStatus;


    @Autowired
    public CurrencyServiceImpl(CurrencyGameRepository gameRepository, GameStatus gameStatus) {
        this.gameRepository = gameRepository;
        this.gameStatus = gameStatus;
    }


    @EventListener(ApplicationReadyEvent.class)
    public void initApplication() {
        Optional<CurrencyLive> currencyLive = fetchDataFromRemoteApi();
        currencyLive.ifPresent(gameRepository::initRepository);
        setStartingGameStatus();
    }

    @Override
    public void setStartingGameStatus() {
        gameStatus.setWinner(false);
        gameStatus.setRandomCurrency(getRandomCurrency());
        gameStatus.setRandomToPlnRate(getRandomToPlnRate(gameStatus.getRandomCurrency()));
        gameStatus.setMessage("Let's START!");
    }

    @Override
    public void checkAnswer(UserInput userInput) {
        try {
            Double rateToGuess = gameStatus.getRandomToPlnRate();
            Double inputDouble = Double.parseDouble(userInput.getInput().replaceAll(",", "."));
            inputDouble = Math.round(inputDouble * 100.0) / 100.0;

            if (inputDouble.equals(rateToGuess)) {
                gameStatus.setMessage("Congratulations! You won!");
                gameStatus.setWinner(true);
            } else if (inputDouble > rateToGuess) {
                gameStatus.setMessage("Too much. Try again!");
            } else {
                gameStatus.setMessage("Too little! Try again!");
            }
        } catch (NumberFormatException ex) {
            System.out.println(ex.getMessage());
            gameStatus.setMessage("Wrong input! Type number!");
        }
    }


    @Override
    public GameStatus getGameStatus() {
        return gameStatus;
    }


    private Optional<CurrencyLive> fetchDataFromRemoteApi() {
        RestTemplate restTemplateCity = new RestTemplate();
        String remoteApiUrl = "https://v6.exchangerate-api.com/v6/" +
                urlUniqueCode + "/latest/usd";
        return Optional.ofNullable(restTemplateCity.getForObject(remoteApiUrl, CurrencyLive.class));
    }


    private Double getRandomToPlnRate(Currency random) {
        Map<Currency, Double> currencyMap = gameRepository.getCurrencyMap();
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


    private Currency getRandomCurrency() {
        Map<Currency, Double> currencyMap = gameRepository.getCurrencyMap();
        Object[] keys = currencyMap.keySet().toArray();
        Object key = keys[new Random().nextInt(keys.length)];
        return (Currency) key;
    }

}
