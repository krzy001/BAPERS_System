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
    private JLabel labelTransactionId;
    private JLabel labelAmount;
    private JLabel labelDate;
    private JLabel labelJobNo;
    private JLabel labelAccountNo;

    public AddPayment(BAPERS system){
        super(system);
        this.setContentPane(this.panelAddPayment);
        this.pack();
        float logo = 80;
        float size = 20;

        labelLogo.setFont(labelLogo.getFont().deriveFont(logo));
        labelLogo.setForeground(Color.RED);
        labelTransactionId.setFont(labelLogo.getFont().deriveFont(size));
        labelAmount.setFont(labelLogo.getFont().deriveFont(size));
        labelDate.setFont(labelLogo.getFont().deriveFont(size));
        labelJobNo.setFont(labelLogo.getFont().deriveFont(size));
        labelAccountNo.setFont(labelLogo.getFont().deriveFont(size));

        btnBack.setPreferredSize(new Dimension(150,30));
        btnAddPayment.setPreferredSize(new Dimension(150,30));
        cardPaymentButton.setPreferredSize(new Dimension(150,30));
        cashPaymentButton.setPreferredSize(new Dimension(150,30));
        updateButton.setPreferredSize(new Dimension(150,30));
        updateButton1.setPreferredSize(new Dimension(150,30));
        updateButton2.setPreferredSize(new Dimension(150,30));
        updateButton3.setPreferredSize(new Dimension(150,30));

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
