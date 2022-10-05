package control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class GetWebService {
    
    String exchangeRate;
    
    public float read(URL url) throws IOException{
        
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
            return Float.parseFloat(exchangeRate);
            }
        } 
            
    public float read(String formCode, String toCode) throws MalformedURLException, IOException {
        URL url = new URL("https://cdn.jsdelivr.net/gh/fawazahmed0/currency-api@1/latest/currencies/" + formCode.toLowerCase() + "/" + toCode.toLowerCase() + ".json");     
        return read(url);
    }
}