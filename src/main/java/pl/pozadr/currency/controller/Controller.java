package pl.pozadr.currency.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.pozadr.currency.controller.thymeleaf.UserInput;
import pl.pozadr.currency.service.CurrencyService;

@org.springframework.stereotype.Controller
public class Controller {
    private final CurrencyService currencyService;


    @Autowired
    public Controller(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }


    @GetMapping("/currency")
    public String getWeatherHome(Model model) {
        model.addAttribute("gameStatus", currencyService.getGameStatus());
        model.addAttribute("userInput", new UserInput());
        return "currency";
    }


    @GetMapping("/get-answer")
    public String getAnswer(@ModelAttribute UserInput userInput) {
        currencyService.checkAnswer(userInput);
        return "redirect:/currency";
    }

    @GetMapping("/new-game")
    public String getNewGame() {
        currencyService.setStartingGameStatus();
        return "redirect:/currency";
    }


}
