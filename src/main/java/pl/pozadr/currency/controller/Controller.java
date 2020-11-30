package pl.pozadr.currency.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.pozadr.currency.service.CurrencyService;

@org.springframework.stereotype.Controller
public class Controller {
    private CurrencyService currencyService;

    @Autowired
    public Controller(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("/currency")
    public String getWeatherHome(Model model) {
        model.addAttribute("currencies", currencyService.getCurrencyRates());
        return "currency";
    }


}
