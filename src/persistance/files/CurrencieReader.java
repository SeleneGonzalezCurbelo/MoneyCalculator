package persistance.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.Currency;
import persistance.CurrencyLoader;

public class CurrencieReader implements CurrencyLoader {
    
    private static CurrencieReader instance;

    public CurrencieReader() {
    }
    
    public static CurrencieReader getInstance(){
        if(instance == null){
            instance = new CurrencieReader();
        }
        return instance;
    }
    
    @Override
    public List<Currency> loadCurrencies(String fileName){
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            List<Currency> currencies = new ArrayList<>();
            lines.forEach((line) -> {
                currencies.add(currencyOf(line));
            });
            return currencies;
        } catch (IOException ex) {
            Logger.getLogger(CurrencieReader.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null;
    }
    
    private Currency currencyOf(String line){
        String [] split = line.split(",");
        return new Currency(split[0], split[1], split[2]);
    }
}