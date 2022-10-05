package control;

import model.Money;

public class ReadData {
    
    Money money;

    public ReadData(float count) {
        this.money = new Money(count);
        System.out.println(money.getCount());
    }
    
    public String getCount(){
        return String.valueOf(money.getCount());
    }
}