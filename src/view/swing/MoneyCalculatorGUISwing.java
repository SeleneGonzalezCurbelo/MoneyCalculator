package view.swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MoneyCalculatorGUISwing extends JFrame{
    
    private static final int WINDOW_WIDTH = 400;
    private static final int WINDOW_HEIGHT = 300;
    
    public MoneyCalculatorGUISwing(JPanel panel, String title){
        super(title);
        initWindow();	
        getContentPane().add(panel, BorderLayout.CENTER);
        pack();
        setVisible(true);
        close();
    }
    
    public void initWindow(){        
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        fileMenu.add(exitMenuItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);
        exitMenuItem.addActionListener(e -> System.exit(0));
    
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        setLocation((screenSize.width - getWidth()) / 2, (screenSize.height - getHeight()) / 2);
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