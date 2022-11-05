package persistance.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Currency;
import persistance.ExchangeRateLoader;

public class ExchangeRateLoaderWebService implements ExchangeRateLoader{
    
    private URL url;
    String exchangeRate;
    
    @Override
    public double getRate(Currency currencyFrom, Currency currencyTo) {
        try {     
            this.url = new URL("https://cdn.jsdelivr.net/gh/fawazahmed0/currency-api@1/latest/currencies/" + currencyFrom.getCode().toLowerCase() + "/" + currencyTo.getCode().toLowerCase() + ".json");
        } catch (MalformedURLException ex) {
            Logger.getLogger(ExchangeRateLoaderWebService.class.getName()).log(Level.SEVERE, null, ex);
        }

        try (InputStream inputStream = url.openStream(); 
                InputStreamReader isr = new InputStreamReader(inputStream); 
                BufferedReader bufr = new BufferedReader(isr)) {
            String str;
            
            String[] jsonLine = null;
            while ((str = bufr.readLine()) != null) {                
                System.out.println(bufr.read());
                jsonLine = str.split(":");
            }
            for(String jsonObject : jsonLine){
                exchangeRate = jsonObject;
            }  
        }catch(IOException e){
            System.out.println("ERROR: WebExchangeRate (getRate) " + e.getMessage());
        }
        return Float.parseFloat(exchangeRate);
    }
    
}
