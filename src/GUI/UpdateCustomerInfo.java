package GUI;
import Control.BAPERS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateCustomerInfo extends Screen {
    private JPanel panelTop;
    private JButton btnLogout;
    private JPanel panelThree;
    private JTextField textField1;
    private JPanel panelFour;
    private JTextField textField2;
    private JPanel panelFive;
    private JTextField textField3;
    private JPanel panelSix;
    private JTextField textField4;
    private JPanel panelSeven;
    private JTextField textField5;
    private JPanel panelEight;
    private JTextField textField6;
    private JTextField textField7;
    private JPanel panelBottom;
    private JButton btnBack;
    private JPanel panelUpdateCustomerInfo;
    private JPanel panelMiddle;
    private JPanel panelNine;
    private JPanel panelTen;
    private JTextField textField8;
    private JLabel labelLogo;
    private JButton updateButton;
    private JButton updateButton1;
    private JButton updateButton2;
    private JButton updateButton3;
    private JButton updateButton4;
    private JButton updateButton5;
    private JButton updateButton6;

    public UpdateCustomerInfo(BAPERS system) {
        super(system);
        this.setContentPane(this.panelUpdateCustomerInfo);
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

        //Update the whole row of information
        /*btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.getController().updateCustomerInfo(
                        textField1.getText(), textField2.getText(), textField3.getText(), textField4.getText(),
                        textField5.getText(), textField6.getText(), textField7.getText(), textField8.getText());
            }
        });*/
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.getController().updateCustomerName(textField1.getText(),textField8.getText());
            }
        });
        updateButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.getController().updateCustomerContactName(textField2.getText(),textField8.getText());
            }
        });
        updateButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.getController().updateCustomerAddress(textField3.getText(),textField8.getText());
            }
        });
        updateButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.getController().updateCustomerPhone(textField4.getText(),textField8.getText());
            }
        });
        updateButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.getController().updateCustomerEmail(textField5.getText(),textField8.getText());
            }
        });
        updateButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.getController().updateCustomerDiscount(textField6.getText(),textField8.getText());
            }
        });
        updateButton6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.getController().updateCustomerValued(textField7.getText(),textField8.getText());
            }
        });
    }
}