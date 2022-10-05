package control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Currency;

public class ReadCurrencie {
    
    private final String fileName;

    public ReadCurrencie(String fileName) {
        this.fileName = fileName;
    }
    
    public List<Currency> loadCurrencies(){
        List<Currency> list = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(this.fileName)));
            IteratorReader iteratorReader = new IteratorReader(reader);
            for(String line : iteratorReader){
                list.add(currencyOf(line));
            }
        } catch (FileNotFoundException ex) {
            System.out.println("CurrencyLoaderFromFule :: loadCurrencies, FileNotFound");
        } catch (IOException ex) {
            System.out.println("CurrencyLoaderFromFule :: loadCurrencies, IOException");
        }   
        return list;
    }
    
    private Currency currencyOf(String line){
        String [] split = line.split(",");
        return new Currency(split[1], split[2], split[0]);
    }
}