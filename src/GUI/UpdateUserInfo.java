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
    private JButton updateButton1;
    private JButton updateButton2;
    private JButton updateButton3;
    private JButton updateButton4;
    private JButton updateButton5;
    private JButton updateButton6;
    private JLabel labelId;
    private JLabel labelName;
    private JLabel labelUsername;
    private JLabel labelPassword;
    private JLabel labelRole;
    private JLabel labelImage;
    private JLabel labelDepartment;

    public UpdateUserInfo(BAPERS system) {
        super(system);
        this.setContentPane(this.panelUpdateUserInfo);
        this.pack();

        //Font and size of buttons established for the interface
        float logo = 80;
        float size = 20;
        labelLogo.setFont(labelLogo.getFont().deriveFont(logo));
        labelLogo.setForeground(Color.RED);
        labelId.setFont(labelLogo.getFont().deriveFont(size));
        labelName.setFont(labelLogo.getFont().deriveFont(size));
        labelUsername.setFont(labelLogo.getFont().deriveFont(size));
        labelPassword.setFont(labelLogo.getFont().deriveFont(size));
        labelRole.setFont(labelLogo.getFont().deriveFont(size));
        labelImage.setFont(labelLogo.getFont().deriveFont(size));
        labelDepartment.setFont(labelLogo.getFont().deriveFont(size));

        btnLogout.setPreferredSize(new Dimension(150,30));
        btnBack.setPreferredSize(new Dimension(150,30));
        updateButton1.setPreferredSize(new Dimension(150,30));
        updateButton2.setPreferredSize(new Dimension(150,30));
        updateButton3.setPreferredSize(new Dimension(150,30));
        updateButton4.setPreferredSize(new Dimension(150,30));
        updateButton5.setPreferredSize(new Dimension(150,30));
        updateButton6.setPreferredSize(new Dimension(150,30));

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

        updateButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textField7.getText().length()>0) {
                    if (textField1.getText().length() > 0) {
                        system.getController().updateUserName(
                                textField1.getText(), textField7.getText());
                    }
                }
            }
        });
        updateButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textField7.getText().length() > 0) {
                    if (textField2.getText().length() > 0) {
                        system.getController().updateUserUsername(
                                textField2.getText(), textField7.getText());
                    }
                }
            }
        });
        updateButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textField7.getText().length() > 0) {
                    if (textField3.getText().length() > 0) {
                        system.getController().updateUserPassword(
                                textField3.getText(), textField7.getText());
                    }
                }
            }
        });
        updateButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textField7.getText().length() > 0) {
                    if (textField4.getText().length() > 0) {
                        system.getController().updateUserRole(
                                textField4.getText(), textField7.getText());
                    }
                }
            }
        });
        updateButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textField7.getText().length() > 0) {
                    if (textField5.getText().length() > 0) {
                        system.getController().updateUserEmail(
                                textField5.getText(), textField7.getText());
                    }
                }
            }
        });
        updateButton6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textField7.getText().length() > 0) {
                    if (textField6.getText().length() > 0) {
                        system.getController().updateUserDepartment(
                                textField6.getText(), textField7.getText());
                    }
                }
            }
        });
    }
}
