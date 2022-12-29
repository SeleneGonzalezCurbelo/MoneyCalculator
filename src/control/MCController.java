package control;

import persistance.web.ExchangeRateLoaderWebService;
import model.Money;
import view.Dialog;
import view.Display;

public class MCController {
    private final Dialog dialog;
    private final Display display;
    private final ExchangeRateLoaderWebService exchangeRateLoader;
    
    public MCController(Dialog dialog, Display display) {
        this.dialog = dialog;
        this.display = display;
        this.exchangeRateLoader = new ExchangeRateLoaderWebService();
    }

    public void execute() {
        Money money = new Money(dialog.getMoney().getCount() * exchangeRateLoader.getRate(dialog.getCurrencyFrom(), dialog.getCurrencyTo()), dialog.getCurrencyTo());
        display.refreshMoney(money);
    }
}
