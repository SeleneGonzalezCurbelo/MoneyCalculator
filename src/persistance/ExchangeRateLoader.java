package persistance;

import model.Currency;

public interface ExchangeRateLoader {
    public double getRate(Currency currencyFrom, Currency currencyTo);
}
