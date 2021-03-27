package GUI;

import Control.BAPERS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CreateCustomerAccount extends Screen{
    private JPanel panelTop;
    private JButton btnCreate;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JPanel panelCreateCustomer;
    private JPanel panelThree;
    private JPanel panelFour;
    private JPanel panelFive;
    private JPanel panelSix;
    private JPanel panelSeven;
    private JPanel panelEight;
    private JPanel panelBottom;
    private JButton btnBack;
    private JButton btnLogout;
    private JTextField textField7;
    private JLabel labelLogo;
    private JLabel labelName;
    private JLabel labelContactName;
    private JLabel labelAddress;
    private JLabel labelPhoneNo;
    private JLabel labelEmail;
    private JLabel labelDiscountPlan;
    private JLabel labelValue;

    public CreateCustomerAccount(BAPERS system) {
        super(system);
        this.setContentPane(this.panelCreateCustomer);
        this.pack();
        float logo = 80;
        float size = 20;
        labelLogo.setFont(labelLogo.getFont().deriveFont(logo));
        labelLogo.setForeground(Color.RED);
        labelName.setFont(labelLogo.getFont().deriveFont(size));
        labelContactName.setFont(labelLogo.getFont().deriveFont(size));
        labelAddress.setFont(labelLogo.getFont().deriveFont(size));
        labelPhoneNo.setFont(labelLogo.getFont().deriveFont(size));
        labelEmail.setFont(labelLogo.getFont().deriveFont(size));
        labelDiscountPlan.setFont(labelLogo.getFont().deriveFont(size));
        labelValue.setFont(labelLogo.getFont().deriveFont(size));


        btnBack.setPreferredSize(new Dimension(150,30));
        btnLogout.setPreferredSize(new Dimension(150,30));
        btnCreate.setPreferredSize(new Dimension(150,30));

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
        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textField1.getText().length() > 0) {
                    if (textField2.getText().length() > 0) {
                        if (textField3.getText().length() > 0) {
                            if (textField4.getText().length() > 0) {
                                if (textField5.getText().length() > 0) {
                                    if (textField6.getText().length() > 0) {
                                        if (textField7.getText().length() > 0) {
                                            system.getController().createCustomerAccount(
                                                    textField1.getText(), textField2.getText(), textField3.getText(), textField4.getText(),
                                                    textField5.getText(), textField6.getText(), textField7.getText());
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        });
    }
}
