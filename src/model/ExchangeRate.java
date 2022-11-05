package model;

public class ExchangeRate {

    private final Currency form;
    private final Currency to;
    private final double exchangeRate; 

    public ExchangeRate(Currency form, Currency to, double exchangeRate) {
        this.form = form;
        this.to = to;
        this.exchangeRate = exchangeRate;
    }

    public Currency getForm() {
        return form;
    }

    public Currency getTo() {
        return to;
    }
    
    public double getExchangeRate() {
        return exchangeRate;
    }
}