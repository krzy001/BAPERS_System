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
    private JButton updateButton;
    private JButton updateButton1;
    private JLabel labelPaymentNo;
    private JLabel labelPaymentMade;
    private JLabel labelTransactionId;

    public RecordCashPayment(BAPERS system) {
        super(system);
        this.setContentPane(this.panelRecordCashPayment);
        this.pack();
        float logo = 80;
        float size = 20;
        labelLogo.setFont(labelLogo.getFont().deriveFont(logo));
        labelLogo.setForeground(Color.RED);
        labelPaymentNo.setFont(labelLogo.getFont().deriveFont(size));
        labelPaymentMade.setFont(labelLogo.getFont().deriveFont(size));
        labelTransactionId.setFont(labelLogo.getFont().deriveFont(size));

        btnBack.setPreferredSize(new Dimension(250,50));
        panelRecordCashPayment.setPreferredSize(new Dimension(250,50));
        btnLogout.setPreferredSize(new Dimension(250,50));
        btnAddCashPayment.setPreferredSize(new Dimension(250,50));
        updateButton.setPreferredSize(new Dimension(250,50));
        updateButton1.setPreferredSize(new Dimension(250,50));

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
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.getController().updateCashPaymentPaid(textField2.getText(),textField1.getText());
            }
        });
        updateButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.getController().updateCashPaymentTransaction(textField3.getText(),textField1.getText());
            }
        });
    }
}
