package GUI;

import Control.BAPERS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateUserInfo extends Screen {
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
    private JPanel panelUpdateUserInfo;
    private JPanel panelMiddle;
    private JLabel labelLogo;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;

    public UpdateUserInfo(BAPERS system) {
        super(system);
        this.setContentPane(this.panelUpdateUserInfo);
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

        /*btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.getController().updateUserInfo(
                        textField1.getText(), textField2.getText(), textField3.getText(), textField4.getText(),
                        textField5.getText(), textField6.getText(), textField7.getText());
            }
        });*/

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.getController().updateUserName(
                        textField1.getText(),textField7.getText());
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.getController().updateUserUsername(
                        textField2.getText(),textField7.getText());
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.getController().updateUserPassword(
                        textField3.getText(),textField7.getText());
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.getController().updateUserRole(
                        textField4.getText(),textField7.getText());
            }
        });
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.getController().updateUserEmail(
                        textField5.getText(),textField7.getText());
            }
        });
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.getController().updateUserDepartment(
                        textField6.getText(),textField7.getText());
            }
        });
    }
}
