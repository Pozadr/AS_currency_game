package pl.pozadr.currency.repository;

import org.springframework.stereotype.Repository;
import pl.pozadr.currency.model.currency.ConversionRates;
import pl.pozadr.currency.model.currency.Currency;
import pl.pozadr.currency.model.currency.CurrencyLive;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CurrencyGameRepositoryImpl implements CurrencyGameRepository {
    private Map<Currency, Double> currencyMap;
    private ConversionRates currencyRates;


    public void initRepository(CurrencyLive currencyLive) {
        currencyRates = currencyLive.getConversionRates();
        currencyMap = new HashMap<>();
        setCurrencyMap();
    }


    public Map<Currency, Double> getCurrencyMap() {
        return currencyMap;
    }


    private void setCurrencyMap() {
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
