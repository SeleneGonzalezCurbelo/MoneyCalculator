package model;

public class Money {
    
    public final double count;
    public final Currency currency;
    
    public Money(double count, Currency currency) {
        this.count = count;
        this.currency = currency;
    }
    
    public double getCount() {
        return count;
    }
    
    public Currency getCurrency(){
        return currency;
    }
    
    @Override
    public String toString(){
        return String.format("%.2f", this.count) + " " + this.currency.getSymbol();
    }
}
