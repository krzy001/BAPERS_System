package GUI;

import Control.BAPERS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class AddPayment extends Screen {
    private JPanel panelTop;
    private JButton btnAddPayment;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField4;
    private JTextField textField5;
    private JPanel panelTwo;
    private JPanel panelThree;
    private JPanel panelFour;
    private JPanel panelFive;
    private JPanel panelSix;
    private JPanel panelAddPayment;
    private JButton btnBack;
    private JButton btnLogout;
    private JPanel panelSeven;
    private JTextField textField3;
    private JLabel labelLogo;

    public AddPayment(BAPERS system){
        super(system);
        this.setContentPane(this.panelAddPayment);
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
        btnAddPayment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.getController().processPayment(
                        textField1.getText(), textField2.getText(), textField3.getText(), textField4.getText(),
                        textField5.getText());
            }
        });
    }
}
