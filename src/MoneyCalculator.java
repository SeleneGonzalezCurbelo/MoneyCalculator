

import persistance.files.ReadCurrencie;
import java.io.IOException;
import java.util.List;
import javax.swing.SwingUtilities;
import model.Currency;
import view.swing.DialogSwing;
import view.swing.MoneyCalculatorGUISwing;

public class MoneyCalculator {
    public static void main(String[] args) throws IOException {      
        
        List<Currency> currencies = ReadCurrencie.getInstance().loadCurrencies("currencies.txt");        
        SwingUtilities.invokeLater(() -> {
            new MoneyCalculatorGUISwing(new DialogSwing(currencies), "Display Money Calculator...");
        });
    }
}