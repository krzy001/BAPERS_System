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

        //Font and size of buttons established for the interface
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

        //When pressed, system logs the user out, resetting certain attributes of the system object in the process
        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.LogOut();
            }
        });
        //When pressed, system goes back by one screen, using the system's stack of history of pages
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.backScreen();
            }
        });

        //If all the text fields are filled in, then the add payment method in the control object is called, using the text from the text fields
        //The if statements are to make sure no blank spaces are entered into the database.
        btnAddPayment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textField.getText().length() > 0) {
                    if (textField2.getText().length() > 0) {
                        if (textField3.getText().length() > 0) {
                            if (textField4.getText().length() > 0) {
                                system.getController().AddPayment(textField.getText(), textField4.getText(), textField3.getText(), textField2.getText());
                            }
                        }
                    }
                }
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
                if (textField.getText().length() > 0) {
                    if (textField1.getText().length() > 0) {
                        system.getController().updatePaymentAmount(textField.getText(), textField1.getText());
                    }
                }
            }
        });
        updateButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textField4.getText().length() > 0) {
                    if (textField1.getText().length() > 0) {
                        system.getController().updatePaymentDate(textField4.getText(), textField1.getText());
                    }
                }
            }
        });
    }
}
