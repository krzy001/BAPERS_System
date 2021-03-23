package GUI;

import Control.BAPERS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RecordCashPayment extends Screen{
    private JPanel panelRecordCashPayment;
    private JPanel panelTop;
    private JLabel labelLogo;
    private JButton btnLogout;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JPanel panelFive;
    private JButton btnAddCashPayment;
    private JButton btnBack;

    public RecordCashPayment(BAPERS system) {
        super(system);
        this.setContentPane(this.panelRecordCashPayment);
        this.pack();
        float logo = 80;
        labelLogo.setFont(labelLogo.getFont().deriveFont(logo));
        labelLogo.setForeground(Color.RED);

        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.LogOut();
            }
        });
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.backScreen();
            }
        });
        btnAddCashPayment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.getController().recordCashPayment(
                        textField1.getText(), textField2.getText(), textField3.getText());
            }
        });
    }
}
