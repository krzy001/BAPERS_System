package GUI;

import Control.BAPERS;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CreateNewUser extends Screen{
    private JPanel panelTop;
    private JPanel panelTwo;
    private JButton btnCreate;
    private JPanel panelCreateNewUser;
    private JPanel panelThree;
    private JPanel panelFour;
    private JPanel panelFive;
    private JPanel panelSix;
    private JPanel panelSeven;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JPanel panelEight;
    private JButton btnBack;
    private JPanel panelBottom;
    private JButton btnLogout;

    public CreateNewUser(BAPERS system) {
        super(system);
        this.setContentPane(this.panelCreateNewUser);
        this.pack();

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
                system.getController().createUserAccount(
                        textField1.getText(), textField2.getText(), textField3.getText(), textField4.getText(),
                        textField5.getText(), textField6.getText());
            }
        });
    }
}
