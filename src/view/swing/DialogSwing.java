package view.swing;

import control.MCController;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Currency;
import model.Money;
import view.Dialog;


public class DialogSwing extends JPanel implements Dialog{
    private final List<Currency> currencies;
    private JTextField cantidad;
    private JButton button;
    private JComboBox<String> comboBoxFrom, comboBoxTo;
    private DisplaySwing displaySwing;
    private MCController controller;
    
     public DialogSwing(List<Currency> currencies) {
        this.currencies = currencies;
        this.createComponentGUI();
    }
     
    @Override
    public Money getMoney() {
        Money money;
        int idx = comboBoxFrom.getSelectedIndex();
        try{
            money = new Money(Double.parseDouble(cantidad.getText()), currencies.get(idx));
        } catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Debe ingresar un número válido", "Error", JOptionPane.ERROR_MESSAGE);
            money = new Money(0, currencies.get(idx));
            cantidad.setText("0");
        }
        return money;
    }

    @Override
    public Currency getCurrencyTo() {
        return currencies.get(comboBoxTo.getSelectedIndex());
    }

    @Override
    public Currency getCurrencyFrom() {
        return currencies.get(comboBoxFrom.getSelectedIndex());
    }
    
    private void createComponentGUI() { 
        this.cantidad = new JTextField(10);
        this.cantidad.setEditable(true);

        comboBoxFrom = new JComboBox<>();
        comboBoxTo = new JComboBox<>();        
        this.currencies.forEach((currency) -> {
            comboBoxFrom.addItem(currency.getCode());
            comboBoxTo.addItem(currency.getCode());
        });
         
        this.add(new JLabel("Enter the value to change:"));this.add(this.cantidad);

        this.add(new JLabel("Introduced currency"));this.add(comboBoxFrom);
        
        this.add(new JLabel("Currency to exchange"));this.add(comboBoxTo);
        
        button = new JButton();
        button.setText("Change");
        this.add(button);
       
        button.addActionListener((ActionEvent evt) -> {
            if (cantidad.getText().length() != 0) {
                DialogSwing.this.displaySwing = new DisplaySwing(DialogSwing.this.getMoney());
                DialogSwing.this.controller = new MCController(DialogSwing.this, displaySwing);
                controller.execute();
                new MoneyCalculatorGUISwing(displaySwing, "Dialog Money Calculator...");
            } else {
                JOptionPane.showMessageDialog(null, "Debe de introducir un valor", "Money Calculator", JOptionPane.WARNING_MESSAGE);
            }
        });
    }
}