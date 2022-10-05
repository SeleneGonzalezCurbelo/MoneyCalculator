package model;

public class Currency {
    
    public String name;
    public String symbol;
    public String code;
    
    private static Currency instance;

    public Currency() {
    }
    
    public Currency(String name, String symbol, String code) {
        this.name = name;
        this.symbol = symbol;
        this.code = code;
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
    
    public static Currency getInstance(){
        if(instance == null){
            instance = new Currency();
        }
        return instance;
    }
}