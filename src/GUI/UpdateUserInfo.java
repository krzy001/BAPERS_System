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

        updateButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.getController().updateUserName(
                        textField1.getText(),textField7.getText());
            }
        });
        updateButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.getController().updateUserUsername(
                        textField2.getText(),textField7.getText());
            }
        });
        updateButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.getController().updateUserPassword(
                        textField3.getText(),textField7.getText());
            }
        });
        updateButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.getController().updateUserRole(
                        textField4.getText(),textField7.getText());
            }
        });
        updateButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.getController().updateUserEmail(
                        textField5.getText(),textField7.getText());
            }
        });
        updateButton6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.getController().updateUserDepartment(
                        textField6.getText(),textField7.getText());
            }
        });
    }
}
