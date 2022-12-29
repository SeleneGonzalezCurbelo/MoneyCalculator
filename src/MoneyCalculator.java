import persistance.files.CurrencieReader;
import model.Currency;
import view.swing.DialogSwing;
import view.swing.MoneyCalculatorGUISwing;

import java.io.IOException;
import java.util.List;
import javax.swing.SwingUtilities;

public class MoneyCalculator {
    public static void main(String[] args) throws IOException {      
        
        List<Currency> currencies = CurrencieReader.getInstance().loadCurrencies("currencies.txt");        
        SwingUtilities.invokeLater(() -> {
            new MoneyCalculatorGUISwing(new DialogSwing(currencies), "Display Money Calculator...").setVisible(true);
        });
    }
}
