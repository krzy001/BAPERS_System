package GUI;

import Control.BAPERS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RecordCardPayment extends Screen {
    private JPanel panelTop;
    private JButton btnAddCardPayment;
    private JTextField textField2;
    private JTextField textField1;
    private JTextField textField4;
    private JTextField textField5;
    private JPanel panelThree;
    private JPanel panelFive;
    private JPanel panelRecordPayment;
    private JButton btnBack;
    private JButton btnLogout;
    private JTextField textField3;
    private JLabel labelLogo;
    private JTextField textField6;
    private JButton updateButton;
    private JButton updateButton1;
    private JButton updateButton2;
    private JButton updateButton3;
    private JButton updateButton4;
    private JTextField textField7;
    private JButton updateButton5;

    public RecordCardPayment(BAPERS system){
        super(system);
        this.setContentPane(this.panelRecordPayment);
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
        btnAddCardPayment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.getController().recordCardPayment(
                        textField3.getText(), textField2.getText(), textField1.getText(), textField4.getText(),
                        textField5.getText(),textField6.getText());
            }
        });
        updateButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.getController().updateCardExpiryDate(textField2.getText(),textField1.getText());
            }
        });
        updateButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.getController().updateCardHolderName(textField3.getText(),textField1.getText());
            }
        });
        updateButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.getController().updateCardPaid(textField4.getText(),textField1.getText());
            }
        });
        updateButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.getController().updateCardCVV(textField6.getText(),textField1.getText());
            }
        });
        updateButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.getController().updateCardPaymentTransaction(textField5.getText(),textField1.getText());
            }
        });
    }
}
