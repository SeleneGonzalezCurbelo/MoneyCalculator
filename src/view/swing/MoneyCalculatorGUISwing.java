package view.swing;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

public class MoneyCalculatorGUISwing extends JFrame{
    
    public MoneyCalculatorGUISwing(DialogSwing dialogSwing, String title){
        super(title);
        getContentPane().add(dialogSwing);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
        close();
    }
    
    public MoneyCalculatorGUISwing(DisplaySwing displaySwing, String title){
        super(title);
        getContentPane().add(displaySwing);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }
    
    public void close() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                setVisible(false);
                System.exit(0);
            }
        });
    }
}
