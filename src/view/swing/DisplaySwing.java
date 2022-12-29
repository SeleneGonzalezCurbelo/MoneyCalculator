package view.swing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import model.Money;
import view.Display;

public final class DisplaySwing extends JPanel implements Display{
    private JTextArea display;
    
    public DisplaySwing(Money money) {
        this.createComponentGUI();
        refreshMoney(money);
    }
    
    @Override
    public void refreshMoney(Money money) {
        display.setText(money.toString());
    }

    private void createComponentGUI() {
        this.setLayout(new FlowLayout());
        this.display = new JTextArea(10,40);
        this.display.setEditable(false);
        JScrollPane scrollDsiplay = new JScrollPane(this.display);
        this.add(scrollDsiplay, BorderLayout.CENTER);
    }
}