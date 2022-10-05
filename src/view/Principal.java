package view;

import control.GetWebService;
import control.ReadCurrencie;
import control.ReadData;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import model.Currency;

public class Principal extends JFrame {
    
    private JTextField cantidad;
    private JLabel result, msg1, msg2, msg3, msg4;
    private JButton boton;
    private JComboBox<String> code1, code2;
    String[] codeList;
    // Arreglarlo 
    ReadCurrencie rc = new ReadCurrencie("E://IS2//Práctica aula//MoneyCalculator//src//persistance//currencies.txt");
    List<Currency> list; 
    
    public Principal() {
        super ("Money Calculator"); 
        initComponents();   
        this.setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);
    }

    private void initComponents() {
        cantidad = new JTextField(10);
        
        result = new JLabel();
        
        msg1 = new JLabel();
        msg2 = new JLabel();
        msg3 = new JLabel();
        msg4 = new JLabel();
        boton = new JButton();
        
        code1 = new JComboBox<>();  
        code2 = new JComboBox<>();
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        msg1.setText("Introduce el valor a cambiar:");
        msg2.setText("Valor equivalente:");
        msg3.setText("Moneda introducida");
        msg4.setText("Moneda a cambiar");
        
        boton.setText("Cambio");
        
        list = rc.loadCurrencies();
        
        for(int i = 0; i < list.size(); i++){
            code1.addItem(list.get(i).getCode());
            code2.addItem(list.get(i).getCode());
        
            
        }

        boton.addActionListener((ActionEvent evt) -> {
            botonActionPerformed(evt);
        });
        
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                    .addComponent(msg1)
                    .addComponent(msg2))
                .addPreferredGap(ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                    .addComponent(boton)
                    .addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(result, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(msg4)
                            .addPreferredGap(ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(code2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(cantidad, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(msg3)
                            .addGap(18, 18, 18)
                            .addComponent(code1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        
        layout.setVerticalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                    .addComponent(msg1)
                    .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(cantidad, GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(msg3)
                        .addComponent(code1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                    .addComponent(msg2)
                    .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(result, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(code2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(msg4)))
                .addGap(29, 29, 29)
                .addComponent(boton)
                .addContainerGap(234, Short.MAX_VALUE))
        );
        
        pack();
        setVisible(true);
    }
    
    private void botonActionPerformed(ActionEvent evt) {
        if(cantidad.getText().length() != 0){
            ReadData rd = new ReadData(Float.parseFloat(cantidad.getText()));            
            
            try { 
                float aux = new GetWebService().read(list.get(code1.getSelectedIndex()).getCode(), list.get(code2.getSelectedIndex()).getCode());
                float ex = Float.parseFloat(rd.getCount())*aux;
                result.setText(Float.toString(ex));
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
    }
}