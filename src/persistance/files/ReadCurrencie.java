package persistance.files;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import model.Currency;
import persistance.LoadCurrency;

public class ReadCurrencie implements LoadCurrency {
    
    private static ReadCurrencie instance;

    public ReadCurrencie() {
    }
    
    public static ReadCurrencie getInstance(){
        if(instance == null){
            instance = new ReadCurrencie();
        }
        return instance;
    }
    
    @Override
    public List<Currency> loadCurrencies(String fileName){
        List<Currency> currencies = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));
            IteratorReader iteratorReader = new IteratorReader(reader);
            for(String line : iteratorReader){
                currencies.add(currencyOf(line));
            }
        } catch (FileNotFoundException ex) {
            System.out.println("CurrencyLoaderFromFule :: loadCurrencies, FileNotFound" + ex.getMessage());
        } 
        return currencies;
    }
    
    private Currency currencyOf(String line){
        String [] split = line.split(",");
        return new Currency(split[0], split[1], split[2]);
    }
}