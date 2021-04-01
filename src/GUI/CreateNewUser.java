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
    private JButton btnBack;
    private JButton btnLogout;
    private JLabel labelLogo;
    private JLabel labelName;
    private JLabel labelUsername;
    private JLabel labelPassword;
    private JLabel labelJobRole;
    private JLabel labelEmail;
    private JLabel labelDepartment;
    private JButton updateButton;
    private JButton updateButton1;
    private JButton updateButton2;
    private JButton updateButton3;
    private JButton updateButton4;
    private JButton updateButton5;
    private JTextField textField7;
    private JLabel labelStaffId;

    public CreateNewUser(BAPERS system) {
        super(system);
        this.setContentPane(this.panelCreateNewUser);
        this.pack();
        float logo = 80;
        float size = 20;

        //Font and size of buttons established for the interface
        labelLogo.setFont(labelLogo.getFont().deriveFont(logo));
        labelLogo.setForeground(Color.RED);
        labelName.setFont(labelLogo.getFont().deriveFont(size));
        labelUsername.setFont(labelLogo.getFont().deriveFont(size));
        labelPassword.setFont(labelLogo.getFont().deriveFont(size));
        labelJobRole.setFont(labelLogo.getFont().deriveFont(size));
        labelEmail.setFont(labelLogo.getFont().deriveFont(size));
        labelDepartment.setFont(labelLogo.getFont().deriveFont(size));
        labelStaffId.setFont(labelLogo.getFont().deriveFont(size));

        btnBack.setPreferredSize(new Dimension(150,30));
        btnLogout.setPreferredSize(new Dimension(150,30));
        btnCreate.setPreferredSize(new Dimension(150,30));
        updateButton.setPreferredSize(new Dimension(150,30));
        updateButton1.setPreferredSize(new Dimension(150,30));
        updateButton2.setPreferredSize(new Dimension(150,30));
        updateButton3.setPreferredSize(new Dimension(150,30));
        updateButton4.setPreferredSize(new Dimension(150,30));
        updateButton5.setPreferredSize(new Dimension(150,30));

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
        //If all the text fields are filled in, then the create user account method in the control object is called, using the text from the text fields
        //The if statements are to make sure no blank spaces are entered into the database.
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

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textField1.getText().length()>0) {
                    if (textField7.getText().length() > 0) {
                        system.getController().updateUserName(textField1.getText(), textField7.getText());
                    }
                }
            }
        });
        updateButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textField2.getText().length()>0) {
                    if (textField7.getText().length() > 0) {
                        system.getController().updateUserUsername(textField2.getText(), textField7.getText());
                    }
                }
            }
        });
        updateButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textField3.getText().length()>0) {
                    if (textField7.getText().length() > 0) {
                        system.getController().updateUserPassword(textField3.getText(), textField7.getText());
                    }
                }
            }
        });
        updateButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textField4.getText().length()>0) {
                    if (textField7.getText().length() > 0) {
                        system.getController().updateUserRole(textField4.getText(), textField7.getText());
                    }
                }
            }
        });
        updateButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textField5.getText().length()>0) {
                    if (textField7.getText().length() > 0) {
                        system.getController().updateUserEmail(textField5.getText(), textField7.getText());
                    }
                }
            }
        });
        updateButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textField6.getText().length()>0) {
                    if (textField7.getText().length() > 0) {
                        system.getController().updateUserDepartment(textField6.getText(), textField7.getText());
                    }
                }
            }
        });
    }
}
