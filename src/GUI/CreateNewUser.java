package GUI;

import Control.BAPERS;

import javax.swing.*;
import java.awt.*;
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
    private JButton btnLogout;
    private JLabel labelLogo;
    private JLabel labelName;
    private JLabel labelUsername;
    private JLabel labelPassword;
    private JLabel labelJobRole;
    private JLabel labelEmail;
    private JLabel labelDepartment;

    public CreateNewUser(BAPERS system) {
        super(system);
        this.setContentPane(this.panelCreateNewUser);
        this.pack();
        float logo = 80;
        float size = 20;
        labelLogo.setFont(labelLogo.getFont().deriveFont(logo));
        labelLogo.setForeground(Color.RED);
        labelName.setFont(labelLogo.getFont().deriveFont(size));
        labelUsername.setFont(labelLogo.getFont().deriveFont(size));
        labelPassword.setFont(labelLogo.getFont().deriveFont(size));
        labelJobRole.setFont(labelLogo.getFont().deriveFont(size));
        labelEmail.setFont(labelLogo.getFont().deriveFont(size));
        labelDepartment.setFont(labelLogo.getFont().deriveFont(size));

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
                if(textField1.getText().length()>0){
                    if(textField2.getText().length()>0){
                        if(textField3.getText().length()>0){
                            if(textField4.getText().length()>0){
                                if(textField5.getText().length()>0){
                                    if(textField6.getText().length()>0){
                                        system.getController().createUserAccount(
                                                textField1.getText(), textField2.getText(), textField3.getText(), textField4.getText(),
                                                textField5.getText(), textField6.getText());
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
