package persistance;

import java.util.List;
import model.Currency;

public interface LoadCurrency {
    public List<Currency> loadCurrencies(String route);
}
