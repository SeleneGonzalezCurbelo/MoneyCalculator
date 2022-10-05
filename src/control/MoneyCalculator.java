package control;

import java.util.List;
import model.Currency;
import view.Principal;

public class MoneyCalculator {
    public static void main(String[] args) {

        Principal gui = new Principal();
        
        ReadCurrencie currencyLoaderFromFile = new ReadCurrencie("E://IS2//Práctica aula//MoneyCalculator//src//persistance//currencies.txt");
        List<Currency> list = currencyLoaderFromFile.loadCurrencies();
        list.forEach((currency) -> {
            System.out.println("Código: " + currency.getCode() + " Nombre: " + currency.getName() + " Simbolo: " + currency.getSymbol());
        });
        
        GetWebService exchangeRateLoaderFromWebService = new GetWebService();
        list.forEach((currency) -> {
            System.out.println(currency.getCode());
        });
    }
}