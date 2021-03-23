package GUI;

import Control.BAPERS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddPayment extends Screen {
    private JPanel panelTop;
    private JLabel labelLogo;
    private JButton btnLogout;
    private JTextField textField2;
    private JTextField textField3;
    private JPanel panelAddPayment;
    private JPanel panelFive;
    private JButton btnAddPayment;
    private JButton btnBack;
    private JButton cardPaymentButton;
    private JButton cashPaymentButton;
    private JTextField textField;
    private JTextField textField4;
    private JButton updateButton;
    private JButton updateButton1;
    private JButton updateButton2;
    private JButton updateButton3;
    private JTextField textField1;

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

            }
        });
        btnAddPayment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.getController().AddPayment(textField.getText(),textField4.getText(), textField3.getText(), textField2.getText());
            }
        });
        cardPaymentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.RecordCardPayment);
            }
        });
        cashPaymentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.RecordCashPayment);
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.getController().updatePaymentAmount(textField.getText(),textField1.getText());
            }
        });
        updateButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.getController().updatePaymentDate(textField4.getText(),textField1.getText());
            }
        });
        updateButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.getController().updatePaymentJobNo(textField3.getText(),textField1.getText());
            }
        });
        updateButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.getController().updatePaymentAccountNo(textField2.getText(),textField1.getText());
            }
        });
    }
}
