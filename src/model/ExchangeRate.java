package model;

public class ExchangeRate {

    private Currency form, to;
    private float exchangeRate; 
    
    public ExchangeRate(float exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public ExchangeRate(Currency form, Currency to) {
        this.form = form;
        this.to = to;
    }
    
    public ExchangeRate(Currency form, Currency to, String read) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Currency getForm() {
        return form;
    }

    public Currency getTo() {
        return to;
    }
    
    public float getExchangeRate() {
        return exchangeRate;
    }
}