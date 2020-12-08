package pl.pozadr.currency.service;

import pl.pozadr.currency.dto.UserInput;
import pl.pozadr.currency.game.GameStatus;

public interface CurrencyService {
    void setStartingGameStatus();
    void checkAnswer(UserInput userInput);
    GameStatus getGameStatus();
}
