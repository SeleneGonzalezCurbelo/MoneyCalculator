package model;

import java.text.NumberFormat;
import java.util.Locale;

public class Currency {
    
    private final String code;
    private final String name;
    private final String symbol;
    
    
    public Currency(String code, String name, String symbol) {
        this.code = code;
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getCode() {
        return code;
    }
    
    @Override
    public String toString(){
        return name + " - " + symbol;
    }

    public String format(double value) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale(this.code));
        return formatter.format(value);
    }
}